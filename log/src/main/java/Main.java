import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Main.class);

        MDC.put("trace_id", UUID.randomUUID().toString());

        logger.error("log test error");
        logger.warn("log test warn");
        logger.info("log test info");
        logger.debug("log test debug");
        logger.trace("log test trace");

        User user = new User();
        user.setAge(18);
        user.setName("kk");

        logger.info("kk is {}", user);


        log.info("anno log test info");
    }

    @Data
    public static class User {
        private Integer age;
        private String name;
    }
}
