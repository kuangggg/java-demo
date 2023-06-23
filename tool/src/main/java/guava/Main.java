package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {

//    private static Cache<String, Object> cm = CacheBuilder.newBuilder()
//            .initialCapacity(10)
//            .concurrencyLevel(5)
//            .expireAfterWrite(3, TimeUnit.SECONDS)
//            .build();

    public static void main(String[] args) {
        Map<String, String> split = Splitter.on("&")
                .withKeyValueSeparator("=")
                .split("id=123&name=xx");

        System.out.println(split);

        List<Integer> integers = Arrays.asList(1, 3, 4);
        String join = Joiner.on(",").join(integers);
        System.out.println(join);

        ImmutableList<String> of = ImmutableList.of("na", "ff");
        System.out.println(of);





    }
}
