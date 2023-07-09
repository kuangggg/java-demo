package time;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LDT {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());

        long millis = Clock.systemDefaultZone().millis();
        System.out.println(millis);

        LocalDateTime yesterday = now.minusDays(1);
        System.out.println(yesterday);

    }
}
