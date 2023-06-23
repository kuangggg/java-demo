import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 集群消费
 */
public class ClusterConsumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(Constant.CONSUMER_GROUP);
        consumer.setNamesrvAddr(Constant.NAME_SERV);
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.subscribe(Constant.TEST_TOPIC, "*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                Optional.ofNullable(list)
                        .orElse(Collections.emptyList())
                        .forEach(x -> {
                            byte[] body = x.getBody();
                            System.out.println(new String(body));
                        });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();
        System.out.println("consumer started");
    }
}
