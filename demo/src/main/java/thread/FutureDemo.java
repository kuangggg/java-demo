package thread;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) {

        StopWatch sw = StopWatch.createStarted();

        ExecutorService pool = Executors.newCachedThreadPool();

        Callable<String> task = () -> {

            TimeUnit.SECONDS.sleep(1);

            return "task ret";
        };

        Future<String> future = pool.submit(task);

        try {
            String result = future.get(3, TimeUnit.SECONDS);
            System.out.println(result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        sw.stop();
        System.out.println(sw.getTime());

    }


}
