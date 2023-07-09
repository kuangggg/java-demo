import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();

        List list = defaultObjectFactory.create(List.class);
        System.out.println(list);
    }
}
