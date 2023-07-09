package less1;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Consumer {

    public static void main(String[] args) {
        Properties pro = new Properties();

        pro.put("bootstrap.servers", "127.0.0.1:9092");
        pro.put("group.id", "myGroup");
        pro.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        pro.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


        String topic = "test_topic";

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(pro);
        List<String> topics = new ArrayList<>();
        topics.add(topic);
        consumer.subscribe(topics);

        System.out.println(consumer.partitionsFor(topic));

        while (true) {
            System.out.println(LocalTime.now());
            ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> consumerRecord : poll) {
                System.out.println(consumerRecord);
            }
        }
    }

}
