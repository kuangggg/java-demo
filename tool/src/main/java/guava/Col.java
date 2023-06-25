package guava;

import com.google.common.collect.*;
import org.checkerframework.checker.nullness.qual.Nullable;



public class Col {

    public static void main(String[] args) {

        ImmutableList<String> of = ImmutableList.of("na", "ff");
        System.out.println(of);

        ImmutableMap<Integer, String> of1 = ImmutableMap.of(1, "yi", 2, "er");
        System.out.println(of1);

        Multimap<@Nullable Object, @Nullable Object> mMap = ArrayListMultimap.create();
        mMap.put("a", "a1");
        mMap.put("a", "a2");
        System.out.println(mMap.get("a"));

        // gis (geographic information system)
        HashBasedTable<Object, Object, Object> hbt = HashBasedTable.create();
        hbt.put(11.11, 12.12, "中央公园");
        System.out.println(hbt.get(11.11, 12.12));

    }
}
