package io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class Channel {


    public static void main(String[] args) {
//        w();
//        r();

        mp();
    }

    public static void mp() {

        try {
            RandomAccessFile raf = new RandomAccessFile("o.demo.txt", "rw");
            FileChannel channel = raf.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

            map.put(1, (byte) 'c');
            raf.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void r() {

        try {
            File file = new File("o.demo.txt");
            System.out.println(file);

            FileInputStream fis = new FileInputStream("o.demo.txt");
            FileChannel channel = fis.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(20);
            channel.read(buf);
            System.out.println(new String(buf.array()));

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void w() {
        String str = "hello worllllllld";

        try {
            FileOutputStream fos = new FileOutputStream("o.demo.txt");

            FileChannel channel = fos.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);

            buf.put(str.getBytes(StandardCharsets.UTF_8));
            buf.flip();

            channel.write(buf);

            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
