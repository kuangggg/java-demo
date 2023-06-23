package thread;

public class WaitNotify {

    private static Object clock = new Object();

    public static void main(String[] args) {

        Thread w = new Thread(() -> {
            synchronized (clock) {

                System.out.println("wait start");
                try {
                    clock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait end");

            }
        });
        w.start();

        Thread n = new Thread(() -> {
            synchronized (clock) {
                System.out.println("notify start");
                clock.notify();
                System.out.println("notify end");
            }
        });
        n.start();
    }
}
