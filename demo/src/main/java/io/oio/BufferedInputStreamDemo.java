package io.oio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamDemo {

    public static void main(String[] args) throws IOException {
        //        FileReader fr = new FileReader("/Users/kuan.zhou/workspace/java-demo/demo/src/main/java/io/oio/demo.txt");
        FileInputStream fis = new FileInputStream("demo/src/main/java/io/oio/demo.txt");

        BufferedInputStream bis = new BufferedInputStream(fis);

        byte[] bytes = new byte[bis.available()];

        bis.read(bytes);

        System.out.println(bytes.length);

    }
}
