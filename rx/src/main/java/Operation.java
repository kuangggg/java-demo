import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

public class Operation {

    public static void main(String[] args) {

        Flux.range(3, 8)
                .as(Mono::from)
                .subscribe(System.out::println);
        //  3

        Flux.range(1, 3)
                .cast(Number.class)
                .subscribe(System.out::println);

        Flux.range(1, 5)
                .collect(Collectors.toList())
                .subscribe(System.out::println);

        Flux.just(1, 2, 3, 5)
                .collectMap(n -> n, n -> n + 100)
                .subscribe(System.out::println);

        Flux.just(1, 2, 3, 4, 5, 3, 1)
                .collectMultimap(n -> n, n -> n + 100)
                .subscribe(System.out::println);

        Flux.just(1, 3, 5, 3, 2, 5, 1, 4)
                .collectSortedList()
                .subscribe(System.out::println);
    }
}
