import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());

        System.out.println(Thread.currentThread().getState());

        Thread thread = new Thread();
        System.out.println(thread.getId());
        System.out.println(thread.getState());
        System.out.println(thread.getName());
        thread.start();
    }
}
