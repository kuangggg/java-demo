package thread.lock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentryLockDemo {

    private static Lock lock = new ReentrantLock();

    private static List<Integer> al = new ArrayList<>();

    public static void main(String[] args) {

        new Thread(() -> {
            if (lock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " get lock");
                for(int i = 0; i < 5; i++) {
                    al.add(i);
                }
            }

            System.out.println(al);
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " release lock");

        }).start();


        new Thread(() -> {
            if (lock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " get lock");
                for(int i = 5; i < 10; i++) {
                    al.add(i);
                }
            }
            System.out.println(al);

            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " release lock");

        }).start();


    }
}
