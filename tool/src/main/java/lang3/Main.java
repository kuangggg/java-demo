package lang3;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String str = "a";
        String[] split = StringUtils.split(str, ",");
        System.out.println(Arrays.toString(split));

        String random = RandomStringUtils.random(19, true, true);
        System.out.println(random);

        int i = RandomUtils.nextInt(0, 10);
        System.out.println(i);

        Validate.isTrue(1 == 2, " 1不等于2");
    }
}