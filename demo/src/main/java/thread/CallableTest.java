package thread;


import java.util.concurrent.*;

public class CallableTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Callable<String> ct = () -> {
            System.out.println("c t run");
            return "c t run";
        };

        Runnable rt = () -> {
            System.out.println("r t run");
        };



        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(rt);

        Future<String> futureTask = pool.submit(ct);

        Future<?> submit = pool.submit(rt);



//        try {
//            int i = 0;
//            while (!futureTask.isDone()) {
//                System.out.println("try get result " + ++i);
//            }
//
//            String result = futureTask.get();
//            System.out.println(result);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }
}
