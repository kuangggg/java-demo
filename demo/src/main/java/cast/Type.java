package cast;

import java.util.Arrays;
import java.util.List;

public class Type {
    public static void main(String[] args) {

        int[] data = {1, 2, 3, 4};
        List<int[]> ints = Arrays.asList(data);
        System.out.println(ints.size());

        Integer[] ia = {1, 2, 4};
        List<Integer> integers = Arrays.asList(ia);
        System.out.println(integers);

        System.out.println(1 + 2 + "hello");
        System.out.println("hello" + 1 + 2);

        System.out.println(-1 % 2);

        System.out.println(10.00 - 9.6);
        System.out.println(10.00f - 9.6f);

        System.out.println(((Object) 1).getClass().getName());
        System.out.println(((Object) 1L).getClass().getName());
        System.out.println(((Object) 1.0).getClass().getName());
        System.out.println(((Object) 1.0f).getClass().getName());

        int base = 30 * 1000 * 100;

        long d1 = base * 2;
        System.out.println(d1);

        // 先溢出再转化，失败
        long d2 = base * 1000;
        System.out.println(d2);

        long d3 = (long) base * 1000;
        System.out.println(d3);
    }
}
