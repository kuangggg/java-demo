package thread.cas;

import java.util.concurrent.TimeUnit;

public class UnsafeRef {

    static volatile Account a = new Account("my account", 0);

    public static void main(String[] args) {

        long s = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {

            new Thread(() -> {

                Account account = new Account(a.getName(), a.getAmount() + 10);

                String tn = Thread.currentThread().getName();
                System.out.println(tn + "->" + account);

                a = account;

                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        long dur = System.currentTimeMillis() - s;

        System.out.println("cost : " + dur);
    }
}
