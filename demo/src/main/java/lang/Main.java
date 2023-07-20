package lang;

public class Main {


    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1000;

        if ((Object) 1 instanceof Integer) {
            System.out.println("1 inst Int");
        }

        if (a == b) {
            System.out.println("eq");
        } else {
            System.out.println("neq");
        }

        Integer c = 11;
        Integer d = 11;

        if (c == d) {
            System.out.println("eq");
        } else {
            System.out.println("neq");
        }


    }
}
