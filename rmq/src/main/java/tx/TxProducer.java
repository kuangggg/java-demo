package tx;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.UUID;

public class TxProducer {

    private static Logger logger = LoggerFactory.getLogger(TxProducer.class);

    protected static LocalTransactionState executeLocalTx(String orderId) {
        int mode = orderId.hashCode() % 3;
        switch (mode) {
            case 1:
                logger.info("#== executeLocalTx success, orderId: {}", orderId);
                return LocalTransactionState.COMMIT_MESSAGE;
            case 2:
                logger.error("#== executeLocalTx fail, orderId: {}", orderId);
                return LocalTransactionState.ROLLBACK_MESSAGE;
            default:
                logger.warn("#== executeLocalTx unknow, orderId: {}", orderId);
                return LocalTransactionState.UNKNOW;
        }
    }

    protected static LocalTransactionState checkLocalTx(String orderId) {
        Random random = new Random();
        int i = random.nextInt(1);

        switch (i) {
            case 1:
                logger.info("#--- checkLocalTx success, orderId: {}", orderId);
                return LocalTransactionState.COMMIT_MESSAGE;
            case 2:
                logger.error("#--- checkLocalTx fail, orderId: {}", orderId);
                return LocalTransactionState.ROLLBACK_MESSAGE;
            default:
                logger.warn("#--- checkLocalTx unknow, orderId: {}", orderId);
                return LocalTransactionState.UNKNOW;
        }
    }

    public static void main(String[] args) throws MQClientException {
        TransactionMQProducer producer = new TransactionMQProducer();
        producer.setNamesrvAddr(Constant.NAME_SERV);
        producer.setProducerGroup(Constant.PRODUCER_GROUP);

        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                String orderId = (String) o;
                return executeLocalTx(orderId);
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                String orderId = messageExt.getKeys();
                return checkLocalTx(orderId);
            }
        });

        producer.start();
        logger.info("#### tx producer service started ...");

        for (int i = 0; i < 10; i++) {
            String orderId = UUID.randomUUID() + "-" + i;
            String msgBody = "create order : " + orderId;
            Message message = new Message(Constant.TOPIC, "tx_tag", orderId, msgBody.getBytes(StandardCharsets.UTF_8));
            TransactionSendResult result = producer.sendMessageInTransaction(message, orderId);
            logger.info("create orderId {}, send result {}", orderId, result.getSendStatus());
        }
    }
}
