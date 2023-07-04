package primary;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main(String[] args) {
        Properties pro = new Properties();

        pro.put("bootstrap.servers", "127.0.0.1:9092");

        pro.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        pro.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        pro.put(ProducerConfig.CLIENT_ID_CONFIG, "my-client-id");

        String topic = "test_topic";

        KafkaProducer<String, String> producer = new KafkaProducer<>(pro);

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello kafka");

        Future<RecordMetadata> send = producer.send(record);

        try {
            // 阻塞等待
            try {
                RecordMetadata recordMetadata = send.get(1, TimeUnit.SECONDS);

            } catch (TimeoutException e) {
                e.printStackTrace();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        producer.close();

    }

}
