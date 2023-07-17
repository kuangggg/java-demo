package concurrent;

import java.util.concurrent.TimeUnit;

public class DeadlockDemo {

    private static String A = "a";

    private static String B = "b";

    public static void main(String[] args) {
        new DeadlockDemo().deadlock();
    }

    private void deadlock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (B) {
                        System.out.println("a");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });


        t1.start();
        t2.start();
    }

}
