package design;

public class VisitorTest {

    interface Element {
        void accept(Visitor v);
    }

    interface Visitor {
        void visitor(AE e);

        void visitor(BE e);
    }

    static class AE implements Element {

        @Override
        public void accept(Visitor v) {
            v.visitor(this);
            System.out.println("ae visited");
        }
    }

    static class BE implements Element {

        @Override
        public void accept(Visitor v) {
            v.visitor(this);
            System.out.println("be visited");
        }
    }

    static class AVistor implements Visitor {

        @Override
        public void visitor(AE e) {
            System.out.println("a_v visiting ae");
        }

        @Override
        public void visitor(BE e) {
            System.out.println("a_v visiting be");
        }

    }

    static class BVistor implements Visitor {


        @Override
        public void visitor(AE e) {
            System.out.println("b_v visiting ae");
        }

        @Override
        public void visitor(BE e) {
            System.out.println("b_v visiting be");
        }


    }


    public static void main(String[] args) {
        AE ae = new AE();
        BE be = new BE();

        AVistor aVistor = new AVistor();

        aVistor.visitor(ae);
        aVistor.visitor(be);

        BVistor bVistor = new BVistor();
        bVistor.visitor(ae);
        bVistor.visitor(be);
    }


}
