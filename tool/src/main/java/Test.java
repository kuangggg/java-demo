import cn.hutool.core.util.StrUtil;

public class Test {
    public static void main(String[] args) {

        String format = StrUtil.format("{}..{}", "a", "b");
        System.out.println(format);
    }
}
