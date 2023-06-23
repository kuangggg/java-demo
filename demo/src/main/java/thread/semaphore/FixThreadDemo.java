package thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class FixThreadDemo {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(50);

        for(int i = 0; i < 1000; i++) {
            pool.submit(new Task());
        }

        pool.shutdown();

    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " call slow service");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
