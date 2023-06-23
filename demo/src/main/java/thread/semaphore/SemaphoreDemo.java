package thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    static java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(5);

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

            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " call slow service begin, acquire semaphore");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            semaphore.release();

            System.out.println(Thread.currentThread().getName() + " call slow service end, release semaphore");
        }
    }
}
