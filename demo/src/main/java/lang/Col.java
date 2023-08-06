package lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Col {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(11);
        intList.add(123);
        intList.removeIf(x -> x == 1);
        System.out.println(intList);
        Predicate<Integer> pi = (i) -> i == 11;
        intList.removeIf(pi);
        System.out.println(intList);

        List<Integer> intAsList = Arrays.asList(1, 2, 4);
        System.out.println(intAsList);

        List<Integer> collect = Stream.of(1, 2, 3).collect(Collectors.toList());
        System.out.println(collect);

        UnaryOperator<Integer> ui = integer -> integer + 2;
        List<Integer> integers = Arrays.asList(1, 2, 4);
        integers.replaceAll(ui);
        System.out.println(integers);


    }
}
