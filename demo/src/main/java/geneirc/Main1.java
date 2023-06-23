package geneirc;

public class Main1 {

    static class HasF {
        public void f() {
            System.out.println("func invoke f");
        }
    }

    static class Container<T extends HasF> {
        private T obj;
        public Container(T t) {
            obj = t;
        }

        public void call() {
            obj.f();
        }
    }


    public static void main(String[] args) {
        HasF hasF = new HasF();

        Container<HasF> hasFContainer = new Container<>(hasF);
        hasFContainer.call();

        GenClass<String> stringGenClass = new GenClass<>();
        stringGenClass.set("abc");
        System.out.println(stringGenClass.get());

        GenMethod genMethod = new GenMethod();
        genMethod.print("aaa");

        genMethod.<Integer>print(11);
    }
}
