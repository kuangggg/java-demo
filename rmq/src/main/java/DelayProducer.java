import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * 延迟发送
 */
public class DelayProducer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer(Constant.PRODUCER_GROUP);
        producer.setNamesrvAddr(Constant.NAME_SERV);
        producer.start();

        Message msg = new Message(Constant.TEST_TOPIC, "", "hello delay msg".getBytes(StandardCharsets.UTF_8));
        // delayTimeLevel："1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h"
        msg.setDelayTimeLevel(3);

        SendResult send = producer.send(msg);
        System.out.println(send);

        producer.shutdown();
    }
}
