package thread;

public class MyThreadDemo {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("extend thread run");
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

        // new 实现接口的匿名类
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread runnable new interface");
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("thread runnable lambda");
            String name = Thread.currentThread().getName();
            System.out.println(name);
        });
        t2.start();
    }
}


