package geneirc;

public class GenMethod {

    public <T> void print(T t) {
        System.out.println(t.getClass().getName());
    }
}
