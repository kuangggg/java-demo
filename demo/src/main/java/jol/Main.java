package jol;

import org.openjdk.jol.info.ClassLayout;

public class Main {

    public static class User {
        long sex;
        Long mobile;
        String name;
    }

    public static void main(String[] args) {
        Object o = new Object();
        // 8 + 4 + | 4 = 16
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        // 8 + 4 + | 8 + 4 + 4 | + 4 = 32
        System.out.println(ClassLayout.parseInstance(new User()).toPrintable());

        // 8 + 4 + 4 + | 28 | + 4 = 48
        System.out.println(ClassLayout.parseInstance(new Integer[7]).toPrintable());
    }
}

