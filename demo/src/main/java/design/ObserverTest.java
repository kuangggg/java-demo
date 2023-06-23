package design;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {

    interface Observer {
        void notify(String s);
    }

    class OneObserver implements Observer {
        @Override
        public void notify(String s) {
            System.out.println("one is notify " + s);
        }
    }

    class TwoObserver implements Observer {
        @Override
        public void notify(String s) {
            System.out.println("tow is notify " + s);
        }
    }

    interface Subject {
        void registerObserver(Observer o);
        void notifyAll(String s);
    }

    class G implements Subject {

        private List<Observer> observers = new ArrayList<>();
        @Override
        public void registerObserver(Observer o) {
                observers.add(o);
        }

        @Override
        public void notifyAll(String s) {
            observers.forEach(o -> o.notify(s));
        }
    }

    public static void main(String[] args) {
        ObserverTest observerTest = new ObserverTest();

        OneObserver oneObserver = observerTest.new OneObserver();
        TwoObserver twoObserver = observerTest.new TwoObserver();

        G g = observerTest.new G();
        g.registerObserver(oneObserver);
        g.registerObserver(twoObserver);
        g.registerObserver((String s) -> {
            System.out.println("lamdba is notify " + s);
        });

        g.notifyAll("hello all");

    }

}
