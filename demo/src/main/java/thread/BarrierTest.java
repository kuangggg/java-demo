package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cb = new CyclicBarrier(2, () -> {
            System.out.println("all t arrive barrier");
        });

        new Thread(() -> {
            System.out.println("t1 start");
            try {
                Thread.sleep(1000L);
                System.out.println("t1 delay");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                cb.await();
                System.out.println("t1 going");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("t2 start");
            try {
                cb.await();
                System.out.println("t2 going");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
