public class Main {

    static {
        System.loadLibrary("test");
    }

    public static native int max(int a, int b);
    // javac Main.java
    // javah Main
    // gcc -shared -l /Library/Java/JavaVirtualMachines/jdk1.8.0_291.jdk/Contents/Home/include test.c -o test.sos
    public static void main(String[] args) {
        System.out.println(max(12, 33));
    }
}
