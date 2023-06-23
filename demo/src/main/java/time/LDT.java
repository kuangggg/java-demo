package time;

import java.time.Clock;
import java.time.LocalDateTime;

public class LDT {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());

        long millis = Clock.systemDefaultZone().millis();
        System.out.println(millis);

        LocalDateTime yesterday = now.minusDays(1);
        System.out.println(yesterday);

    }
}
