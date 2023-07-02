package buf;

import java.nio.ByteBuffer;

public class ByteBufferDemo {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        String val = "nett demo";

        buffer.put(val.getBytes());

        buffer.flip();

        byte[] vArr = new byte[buffer.remaining()];
        buffer.get(vArr);

        String decodeVal = new String(vArr);
        System.out.println(decodeVal);

    }
}
