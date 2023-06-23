package thread;


import java.util.concurrent.*;

public class CallableTest {


    public static void main(String[] args) {

        String s = "tag";

        Callable<String> task = () -> {
            Thread.sleep(1);
            return "hello async task" + s;
        };


        ExecutorService pool = Executors.newCachedThreadPool();
        Future<String> futureTask = pool.submit(task);

        try {
            int i = 0;
            while (!futureTask.isDone()) {
                System.out.println("try get result " + ++i);
            }

            String result = futureTask.get();
            System.out.println(result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
