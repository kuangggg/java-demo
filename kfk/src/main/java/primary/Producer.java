package primary;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

public class Producer {

    public static void main(String[] args) {
        Properties pro = new Properties();

        pro.put("bootstrap.servers", "127.0.0.1:9092");

        pro.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        pro.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        pro.put("acks", "all");

        // ...

        String topic = "test_topic";

        KafkaProducer<String, String> producer = new KafkaProducer<>(pro);

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello first kafka");

        Future<RecordMetadata> send = producer.send(record);

        producer.close();

    }

}
