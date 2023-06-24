package caffeine;



import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class DefaultTest {

    public static void main(String[] args) {
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .maximumSize(100)
                .removalListener((k, v, c) -> {
                    System.out.println("caffeine clear notify k :" + k);
                })
                .build();
        String v1 = cache.get("k1", k -> {
            return "default value";
        });

        System.out.println(v1);

        System.out.println(cache.getIfPresent("k1"));

    }
}
