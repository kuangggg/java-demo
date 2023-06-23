package thread.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SafeRef {

    private static AtomicReference<Account> af
            = new AtomicReference<>(new Account("my account", 0));


    public static void main(String[] args) {



        long s = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                Account afa = af.get();

                Account account = new Account(afa.getName(), afa.getAmount() + 10);

                if (af.compareAndSet(afa, account)) {
                    String tn = Thread.currentThread().getName();
                    System.out.println(tn + "->" + account);
                }

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
