package loader;

import java.io.*;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    protected void say() {
        System.out.println("hello my loader");
    }

    public static void main(String[] args) throws Exception {

        String lib = "/Users/kuan.zhou/clib";
        String className = "loader.MyClassLoader";

        MyClassLoader myClassLoader = new MyClassLoader(lib);
        Class<?> clz = myClassLoader.loadClass(className);
        Object obj = clz.newInstance();
        Method sayMethod = clz.getDeclaredMethod("say", null);
        sayMethod.invoke(obj, null);
    }

    private String libPath;

    public MyClassLoader(String libPath) {
        this.libPath = libPath;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        int idx = name.lastIndexOf('.');
        String fileName;
        if(idx == -1) {
            fileName = name + ".class";
        } else {
            fileName = name.substring(idx + 1) + ".class";
        }

        File file = new File(libPath + "/" + fileName);

        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            int len = 0;
            try {
                while ((len = fis.read()) != -1) {
                    byteArrayOutputStream.write(len);
                }
            } catch (IOException e) {
            }

            byte[] bytes = byteArrayOutputStream.toByteArray();

            fis.close();
            byteArrayOutputStream.close();

            return defineClass(name, bytes, 0, bytes.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

}
