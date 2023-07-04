package less1;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class MyProducerInterceptor implements ProducerInterceptor<String, String> {

    private volatile long sendSuccess = 0L;
    private volatile long sendFail = 0L;

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {

        String modifyValue = "prefix-" + record.value();
        return new ProducerRecord<>(record.topic(),
                record.partition(),
                record.timestamp(),
                record.key(),
                modifyValue,
                record.headers()
        );
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if (e == null) {
            sendSuccess++;
        } else {
            sendFail++;
        }
    }

    @Override
    public void close() {
        System.out.printf("close before stat success %s, fail %s", sendSuccess, sendFail);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
