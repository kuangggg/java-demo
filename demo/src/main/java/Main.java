import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<String> generate = Stream.generate(() -> "echo");

        generate.forEach(System.out::println);

        System.out.println("ss");
    }
}
