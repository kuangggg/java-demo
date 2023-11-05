package design;

public class ProxyInheritTest {

    interface Subject {
        void process();
    }

    class RealSubject implements Subject {
        @Override
        public void process() {
            System.out.println("real subject process");
        }
    }

    class ProxySubject extends RealSubject implements Subject {

        @Override
        public void process() {
            System.out.println("pre process");
            super.process();
            System.out.println("post process");
        }
    }

    public static void main(String[] args) {
        ProxyInheritTest proxyInheritTest = new ProxyInheritTest();
        ProxySubject proxySubject = proxyInheritTest.new ProxySubject();
        proxySubject.process();
    }
}
