package geneirc;

public class GenClass<T> {
    private T t;

    void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
