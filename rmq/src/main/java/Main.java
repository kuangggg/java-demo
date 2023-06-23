import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("info");

        java.util.logging.Logger originLogger = java.util.logging.Logger.getLogger(Main.class.getName());
        originLogger.info("xxxx");


        for(int j = 0; j<100; j++) {
            int i = new Random().nextInt(5);
            System.out.println(i + " " + i%3);
        }
    }
}
