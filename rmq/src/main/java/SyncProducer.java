import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * 同步发送消息
 */
public class SyncProducer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer(Constant.PRODUCER_GROUP);
        producer.setNamesrvAddr(Constant.NAME_SERV);
        producer.start();

        Message msg = new Message(Constant.TEST_TOPIC, "", "hello sync msg".getBytes(StandardCharsets.UTF_8));

        SendResult send = producer.send(msg);
        System.out.println(send);

        producer.shutdown();
    }
}
