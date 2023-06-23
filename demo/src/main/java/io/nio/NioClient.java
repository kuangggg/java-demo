package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NioClient {
    public static void main(String[] args) {
        try {
            SocketChannel sc = SocketChannel.open();
            sc.configureBlocking(false);

            InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 6666);

            if(!sc.connect(isa)) {
                while (!sc.finishConnect()) {
                    System.out.println("#=== client not block, continue");
                }
            }

            String str = "hello nio";

            ByteBuffer bf = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));

            sc.write(bf);

            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
