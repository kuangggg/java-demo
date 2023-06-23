package io.oio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class Stream {

    public void readOneByte() {

        try {
            FileInputStream in = new FileInputStream("io.demo.txt");
            int data = -1;
            while ((data = in.read()) != -1) {
                System.out.println(data);
                System.out.println((char) data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readBlockByte() {
        try {
            FileInputStream in = new FileInputStream("io.demo.txt");

            byte[] buf = new byte[4];

            int len = -1;
            while ((len = in.read(buf)) != -1) {
                System.out.printf("read %d byte, %s \n", len, Arrays.toString(buf));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bufRead() {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("io.demo.txt"));

            byte[] buf = new byte[3];

            int len = -1;
            while ((len = in.read(buf)) != -1) {
                System.out.printf("read %d byte, %s \n", len, Arrays.toString(buf));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nio() {
        try {
            RandomAccessFile rw = new RandomAccessFile("io.demo.txt", "rw");
            FileChannel channel = rw.getChannel();

            ByteBuffer allocate = ByteBuffer.allocate(1024);

            try {
                int read = channel.read(allocate);

                while (read != -1) {
                    allocate.flip();
                    while (allocate.hasRemaining()) {
                        System.out.println((char) allocate.get());
                    }
                    allocate.compact();
                    read = channel.read(allocate);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
