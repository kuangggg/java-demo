package loader;

class SuperClass {
    static {
        System.out.println("super init");
    }

    public static int val = 123;
}

class Sub extends SuperClass {
    static {
        System.out.println("sub class init");
    }
}

class A {
    static {
        System.out.println("a static init");
    }

    public static final String h = "hello";
}

public class Demo {

    public static void main(String[] args) throws Throwable {
        System.out.println(Sub.val);

        Class<A> aClass = A.class;

        Class<?> a = Class.forName("loader.A");

        SuperClass[] superClasses = new SuperClass[10];

        System.out.println(A.h);
    }


}
