package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory {

    static public class MyThreadMaker implements ThreadFactory {

        private static AtomicInteger threadNo = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            int no = threadNo.incrementAndGet();
            String name = "myThreadMaker -> no " + no;
            Thread thread = new Thread(r, name);
            return thread;
        }

        public static void main(String[] args) {
            ExecutorService pool = Executors.newFixedThreadPool(2, new MyThreadMaker());

            for (int i = 0; i < 5; i++) {
                pool.submit(() -> {
                    String name = Thread.currentThread().getName();
                    System.out.println( name + " task running");
                });
            }

            pool.shutdown();
        }
    }


}
