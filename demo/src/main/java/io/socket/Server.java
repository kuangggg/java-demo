package io.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        try {

            ExecutorService pool = Executors.newCachedThreadPool();

            ServerSocket ss = new ServerSocket(6666);
            System.out.println("#=== server is running 6666");
            for(;;) {
                Socket accept = ss.accept();
                System.out.println("#=== connect from " + accept.getRemoteSocketAddress());

                pool.execute(() -> handle(accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handle(Socket s) {
        byte[] buf = new byte[1024];
        try {
            InputStream inputStream = s.getInputStream();
            while (true) {
                int read = inputStream.read(buf);
                if(read == -1)
                    break;
                System.out.println(new String(buf, 0, read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("#=== disconnect client");

            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
