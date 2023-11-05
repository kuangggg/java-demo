import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.io.IOUtil;
import org.apache.commons.lang3.math.NumberUtils;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Test {

    @Data
    public static class Address {
        private int priority;

        private String name;
    }

    class b {

    }


    public static void main(String[] args) throws IOException {
        short a = 0b111111111111111;
        byte age = 0b1111111;

        System.out.println(0b1111111);
        System.out.println(a);
//        Integer abc111 = Integer.valueOf("abc111");
//
//        System.out.println(abc111);

        int abc1111 = NumberUtils.toInt("abc111", 1111);

        System.out.println(abc1111);


        System.out.println(Test.class.getClassLoader());

        Address a1 = new Address();
        a1.setName("hhhh");
        a1.setPriority(2);

        Address a2 = new Address();
        a2.setName("cc");
//        a2.setPriority(1);

        List<Address> al = Lists.newArrayList();
        al.add(a1);
        al.add(a2);

        al.sort(Comparator.comparingInt(Address::getPriority));

        System.out.println(al);



        System.out.println(Test.class.getClassLoader().getResourceAsStream("a.txt"));


        InputStream resourceAsStream = Test.class.getResourceAsStream("a.txt");

        String s = IOUtil.toString(resourceAsStream);

        System.out.println(s);

        HashMap<@Nullable Object, @Nullable Object> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("a", "v");
        Object o = objectObjectHashMap.putIfAbsent("a", "v");

        System.out.println(o);


        ArrayList<@Nullable Object> objects = Lists.newArrayList();


    }
}
