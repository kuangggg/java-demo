package anno;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main1 {

    public static void main(String[] args) {


        try {
            final Class<?> aClass = Class.forName("anno.RefTest");

            System.out.println("打印 field=========");
            final Field[] fields = aClass.getFields();
            for(Field f : fields) {
                System.out.println(f);
            }

            System.out.println("打印 declared field=======");
            final Field[] declaredFields = aClass.getDeclaredFields();
            for(Field f : declaredFields) {
                System.out.println(f);
            }

            System.out.println("打印 method======");
            final Method[] methods = aClass.getMethods();
            for(Method m : methods) {
                System.out.println(m);
            }
            //不包含继承
            System.out.println("打印 declared method ======");
            final Method[] declaredMethods = aClass.getDeclaredMethods();
            for(Method m : declaredMethods) {
                System.out.println(m);
            }

            final Constructor<?>[] constructors = aClass.getConstructors();
            for(Constructor c : constructors) {
                System.out.println(c);
            }

//            System.out.println("无参实力化 =======");
//            final RefTest refTest = (RefTest) aClass.newInstance();

            System.out.println("构造实力化 ======");

            final Constructor<?> constructor = aClass.getConstructor(String.class, String.class, String.class);
            final RefTest refTest = (RefTest) constructor.newInstance("a", "b", "c");
            System.out.println(refTest);

            System.out.println("获取方法并执行");
            final Method publicMethod = aClass.getMethod("publicMethod", String.class, Integer.class);
            publicMethod.invoke(refTest, "1111111", 333);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




    }
}
