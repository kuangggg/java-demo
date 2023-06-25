package guava;

import com.google.common.primitives.Ints;

public class Basic {
    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 99};
        int max = Ints.max(ints);
        System.out.println(max);

    }
}
