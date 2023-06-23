package io.nio;

import java.nio.IntBuffer;

public class Buf {

    public static void main(String[] args) {

        IntBuffer allocate = IntBuffer.allocate(5);

        for(int i = 0; i < allocate.capacity(); i++) {
            allocate.put(i * 2);
        }

        allocate.flip();

        while (allocate.hasRemaining()) {
            System.out.println(allocate.get());
        }
    }
}
