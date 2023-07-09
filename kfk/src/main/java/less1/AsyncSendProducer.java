package less1;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncSendProducer {

    public static void main(String[] args) {
        Properties pro = new Properties();

        pro.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        pro.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        pro.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        pro.put(ProducerConfig.CLIENT_ID_CONFIG, "my-client-id");
        pro.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, MyProducerInterceptor.class.getName());
        pro.put(ProducerConfig.ACKS_CONFIG, "1");

        String topic = "test_topic";

        KafkaProducer<String, String> producer = new KafkaProducer<>(pro);

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello kafka");

        Future<RecordMetadata> send = producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e != null) {
                    e.printStackTrace();
                } else {
                    System.out.println(recordMetadata);
                }
            }
        });
        System.out.println(send);

        producer.close();

    }

}
