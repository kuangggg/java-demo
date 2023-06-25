import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(2), Duration.ofSeconds(3)).subscribe(System.out::println);

        Mono.just("abc").subscribe(System.out::println);

        Flux.just("a", "b", "c").subscribe(System.out::println);

        Stream<String> ss = Stream.of("f", "d");
        Flux.fromStream(ss).subscribe(System.out::println);

        Flux.range(3, 5).subscribe(System.out::println);
    }
}
