package design;

public class ProxyComposeTest {

    interface Subject {
        void process();
    }

    class RealSubject implements Subject {
        @Override
        public void process() {
            System.out.println("real subject process");
        }
    }

    class ProxySubject implements Subject {

        private RealSubject realSubject;

        ProxySubject(RealSubject realSubject) {
            this.realSubject = realSubject;
        }

        @Override
        public void process() {
            System.out.println("pre process");
            realSubject.process();
            System.out.println("post process");
        }
    }

    public static void main(String[] args) {
        ProxyComposeTest proxyComposeTest = new ProxyComposeTest();
        RealSubject realSubject = proxyComposeTest.new RealSubject();
        ProxySubject proxySubject = proxyComposeTest.new ProxySubject(realSubject);
        proxySubject.process();
    }
}
