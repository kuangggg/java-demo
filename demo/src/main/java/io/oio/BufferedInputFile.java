package io.oio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {

    public static void main(String[] args) throws IOException {

        System.out.println(System.getProperty("user.dir"));

//        FileReader fr = new FileReader("/Users/kuan.zhou/workspace/java-demo/demo/src/main/java/io/oio/demo.txt");
        FileReader fr = new FileReader("demo/src/main/java/io/oio/demo.txt");

        BufferedReader br = new BufferedReader(fr);

        String s;

        StringBuilder sb = new StringBuilder();

        while ((s = br.readLine()) != null) {
            sb.append(s+"\n");
        }

        br.close();

        System.out.println(sb);

    }
}
