package thread.pool;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class ShutdownDemo {

    @SneakyThrows
    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory());

        for (int i = 1; i <= 8; i++) {

            String tn = "task " + i;

            try {

                pool.execute(() -> {
                    System.out.println("-------->" + Thread.currentThread().getName() + " " + tn + " begin");
                    try {
                        // 模拟任务耗时处理
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("-------->" + Thread.currentThread().getName() + " " + tn + " end");
                });

            } catch (RejectedExecutionException e) {
                System.out.println("--------> reject task " + tn);
            }

            if (i == 4) {

//                pool.shutdown();
//                List<Runnable> runnables = pool.shutdownNow();
//                System.out.println(runnables.size());

                // 最佳实践

                /**
                 *  调用 shutdown，阻止新提交任务，并让等待队列中的任务执行完成
                 *  调用 awaitTermination()，保证等待队列中的任务最多执行 800 ms，以防止执行任务时间太长或被阻 塞，而导致 ExecutorService 不能被销毁
                 *  在 awaitTermination 等待 s 后，ExecutorService 中还有任务没执行完，则调用 shutdownNow 强行终止，以释放 ExecutorService 资源。
                 */
                pool.shutdown();

                long s = System.currentTimeMillis();

                if (!pool.awaitTermination(1, TimeUnit.SECONDS)) {

                    long forceCost = System.currentTimeMillis() - s;
                    System.out.println("wait queue task force over, cost :" + forceCost);
                    System.out.println("not processed task count " + pool.getQueue().size());

                    pool.shutdownNow();
                } else {
                    long normalCost = System.currentTimeMillis() - s;
                    System.out.println("wait queue task over, cost :" + normalCost);
                    System.out.println("--------> pool shutdown");
                }
            }
        }
    }
}
