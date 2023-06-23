package thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentryLockCondDemo {

    private static Lock lock = new ReentrantLock();

    private static Condition cond = lock.newCondition();

    public static void main(String[] args) {

        new Thread(() -> {
            lock.lock();

            String name = Thread.currentThread().getName();

            try {
                System.out.println(name + "await begin");
                cond.await();
                System.out.println(name + "await end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.unlock();

        }).start();


        new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock();
            String name = Thread.currentThread().getName();

            System.out.println(name + " signal all begin");
            cond.signalAll();

            System.out.println(name + " signal all end");

            lock.unlock();

        }).start();


    }
}
