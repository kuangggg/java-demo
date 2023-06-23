package thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorPoolDemo {

    public static void main(String[] args) {

        //--------------------

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        ses.schedule(() -> System.out.println("delay "), 3, TimeUnit.SECONDS);

        ses.shutdown();
    }
}
