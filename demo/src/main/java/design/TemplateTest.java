package design;

import java.util.function.Consumer;

public class TemplateTest {

    public static void main(String[] args) {
        TemplateTest templateTest = new TemplateTest();
        DBTemplate dbTemplate = templateTest.new DBTemplate();
        dbTemplate.process(11, (i) -> System.out.println("hello " + i));
    }


    class DBTemplate {

        public void process(Integer i, Consumer<Integer> c) {
            c.accept(i);
        }
    }


}
