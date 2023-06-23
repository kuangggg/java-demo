package pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    //  ?：告诉引擎匹配前导字符0次或一次。事实上是表示前导字符是可选的。
    // +： 告诉引擎匹配前导字符1次或多次。
    // *:：告诉引擎匹配前导字符0次或多次。
    // {min, max}:：告诉引擎匹配前导字符min次到max次。

    public static void main(String[] args) {

        List<String> names = Arrays.asList("张三 ", "李四 ", " 王老五 ", " 李三 ", " 刘老四 ");
        int 张 = names.stream()
                .filter(name -> name.startsWith("张"))
                .mapToInt(String::length)
                .max()
                .orElse(1);

        System.out.println(张);



    }
}
