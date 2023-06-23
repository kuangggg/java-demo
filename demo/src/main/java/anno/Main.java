package anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

@MyAnnoType(pro2="assign anno val", pro1=1)
public class Main {

    @MyAnnoField(name = "anno field assign val1")
    private String testPrv;
    @MyAnnoField
    public String testPub;

    @MyAnnoMethod
    public void test(@MyAnnoParam String val) {

    }

    @MyAnnoMethod(name = "assign anno method")
    public static void main(String[] args) {
        System.out.println(Main.class);
        System.out.println(MyAnnoType.class);


        System.out.println(Main.class.isAnnotation());
        System.out.println(MyAnnoType.class.isAnnotation());

        //是否被当前注解修饰
        System.out.println(Main.class.isAnnotationPresent(MyAnnoType.class));
        System.out.println(Main.class.getAnnotation(MyAnnoType.class).pro());
        System.out.println(Main.class.getAnnotation(MyAnnoType.class).pro1());
        System.out.println(Main.class.getAnnotation(MyAnnoType.class).pro2());

        System.out.println("field anno ===========");
        Field[] fs = Main.class.getDeclaredFields();
        System.out.println(Arrays.toString(fs));
        for(Field f : fs) {
            System.out.println(f.getName());
            System.out.println(f.getAnnotation(MyAnnoField.class).name());
        }

        System.out.println("method anno ===========");
        Method[] ms = Main.class.getDeclaredMethods();
        for(Method m : ms) {
            System.out.println(m.getName());
            if(m.isAnnotationPresent(MyAnnoMethod.class)) {
                System.out.println(m.getAnnotation(MyAnnoMethod.class).name());
            }
        }

        System.out.println("param anno ===========");
        for(Method m : ms) {
            Parameter[] ps = m.getParameters();
            for(Parameter p : ps) {
                if(p.isAnnotationPresent(MyAnnoParam.class)) {
                    System.out.println(p.getAnnotation(MyAnnoParam.class).annotationType());
                    System.out.println(p.getAnnotation(MyAnnoParam.class).name());
                }
            }
        }

    }
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnoType {
    String pro() default "default string val";
    int pro1() default 0;
    String pro2();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MyAnnoField {
    String name() default "not assing anno field";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnoMethod {
    String name() default "not assing anno method";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface MyAnnoParam {
    String name() default "not assing anno method";
}