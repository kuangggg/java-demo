package thread.pool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10,
                60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000));
        pool.execute(() -> System.out.println("task, runnable, execute"));


        //-----------------

        Callable<String> taskResult = () -> "task, callable, submit";
        Future<String> submit = pool.submit(taskResult);

        try {
            String s = submit.get();
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //----------------

        FutureTask<String> futureTask = new FutureTask<>(() -> "future task, execute");
        pool.execute(futureTask);

        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            boolean b = pool.awaitTermination(1, TimeUnit.SECONDS);
            if(b) {
                System.out.println("poll shut down success");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();


    }
}
