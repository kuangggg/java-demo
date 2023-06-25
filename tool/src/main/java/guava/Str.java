package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

public class Str {
    public static void main(String[] args) {

        Map<String, String> split = Splitter.on("&")
                .withKeyValueSeparator("=")
                .split("id=123&name=xx");
        System.out.println(split);


        Joiner joiner = Joiner.on(", ");
        String join = joiner.skipNulls().join("hello ", "guava", "joiner");
        System.out.println(join);

        HashMap<@Nullable Object, @Nullable Object> hm = Maps.newHashMap();
        hm.put("k1", "v1");
        hm.put("k2", "v2");

        Joiner jLine = Joiner.on("\r\n");
        String hms = jLine.withKeyValueSeparator("=").join(hm);
        System.out.println(hms);
    }
}
