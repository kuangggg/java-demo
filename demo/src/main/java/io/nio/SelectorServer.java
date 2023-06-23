package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorServer {
    public static void main(String[] args) {

        try {
            Selector s = Selector.open();

            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(6666));
            ssc.configureBlocking(false);
            ssc.register(s, SelectionKey.OP_ACCEPT);

            while (true) {
                if(s.select(1000) == 0) {
                    System.out.println("#=== server wait, no client accept");
                    continue;
                }

                Set<SelectionKey> sk = s.selectedKeys();
                Iterator<SelectionKey> i = sk.iterator();

                while (i.hasNext()) {
                    SelectionKey next = i.next();
                    if(next.isAcceptable()) {
                        SocketChannel accept = ssc.accept();
                        System.out.println("#=== client connect, " + accept.hashCode());
                        accept.configureBlocking(false);
                        accept.register(s, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    }

                    if(next.isReadable()) {
                        SocketChannel sc = (SocketChannel) next.channel();
                        ByteBuffer buf = (ByteBuffer) next.attachment();
                        sc.read(buf);
                        System.out.println("#=== client read, " + new String(buf.array()));
                    }

                    i.remove();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
