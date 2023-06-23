package thread;


import java.util.concurrent.TimeUnit;

public class Join {

    static int count = 0;

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count = 10;

        });

        thread.start();

        thread.join();

        System.out.println(count);


    }
}
