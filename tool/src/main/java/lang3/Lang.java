package lang3;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Lang {
    public static void main(String[] args) {
        String str = null;
        boolean empty = StringUtils.isEmpty(str);
        System.out.println(empty);

        String str1 = "";
        System.out.println(StringUtils.isEmpty(str1));

        String str2 = " ";
        System.out.println(StringUtils.isEmpty(str2));
        System.out.println(StringUtils.isBlank(str2));

        System.out.println(StringUtils.isNumeric("2323"));
        System.out.println(StringUtils.isNumeric("2323b"));

        System.out.println(StringUtils.left("abc", 2));

        System.out.println(StringUtils.countMatches("aabbcccdef", "a"));

        System.out.println(RandomStringUtils.randomAlphabetic(10));

        String[] split = StringUtils.split("a", ",");
        System.out.println(Arrays.toString(split));

        System.out.println(RandomStringUtils.random(19, true, true));

        System.out.println(RandomUtils.nextInt(0, 10));
    }
}
