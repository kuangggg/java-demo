package thread;

public class ThreadLocalTest {

    public static void main(String[] args) {

        ThreadLocal<String> stringThreadLocal = ThreadLocal.withInitial(() -> "t_str");

        String s = stringThreadLocal.get();
        System.out.println(s);
    }
}
