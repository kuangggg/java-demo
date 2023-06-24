package caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.testing.FakeTicker;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        FakeTicker fakeTicker = new FakeTicker();

        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .maximumSize(50)
                .removalListener((k, v, c) -> {
                    System.out.println("caffeine clear notify k :" + k);
                })
                .ticker(fakeTicker::read)
                .recordStats()
                .build();

        cache.put("k1", "v1");
        fakeTicker.advance(6, TimeUnit.SECONDS);
        System.out.println("time gone away");
        System.out.println(cache.getIfPresent("k1"));

        for (int i = 2; i < 100; i++) {
            cache.put("k" + i, "v" + i);
        }

        System.out.println(cache.stats());

        cache.invalidateAll();
    }
}
