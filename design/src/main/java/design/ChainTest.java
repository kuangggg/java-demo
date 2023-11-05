package design;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainTest {


    abstract class ProcessObject<T> {
        protected ProcessObject<T> successor;

        public void setSuccessor(ProcessObject<T> successor) {
            this.successor = successor;
        }

        public T handle(T input) {
            T t = handleWork(input);
            if(successor != null) {
                return successor.handleWork(t);
            }
            return t;
        }

        abstract protected T handleWork(T input);
    }

    public class HeadProcess extends ProcessObject<String> {
        @Override
        protected String handleWork(String input) {
            return "add head " + input;
        }
    }

    public class TailProcess extends ProcessObject<String> {
        @Override
        protected String handleWork(String input) {
            return input + " add tail";
        }
    }

    public static void main(String[] args) {
        ChainTest chainTest = new ChainTest();

        HeadProcess headProcess = chainTest.new HeadProcess();
        TailProcess tailProcess = chainTest.new TailProcess();

        headProcess.setSuccessor(tailProcess);
        String chain_test = headProcess.handle("chain test");
        System.out.println(chain_test);

        UnaryOperator<String> p = (String s) -> "lambda " + s;
        UnaryOperator<String> p1 = (String s) -> "la " + s;
        Function<String, String> piple = p.andThen(p1);
        System.out.println(piple.apply("hhhh"));

    }

}
