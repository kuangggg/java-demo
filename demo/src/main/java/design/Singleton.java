package design;

public class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("cla constructed");
    }

    public static Singleton getInstance() {

        if(instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return Singleton.instance;
    }

    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
    }


}


