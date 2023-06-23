package anno;

public class RefTest {

    public String publicPro;
    protected String protectedPro;
    private String privatePro;

    public RefTest(String v, String v1, String v2) {
        publicPro = v;
        privatePro = v1;
        protectedPro = v2;
    }

    public void publicMethod(String str, Integer i) {
        System.out.println("invoke method str = " + str + " i = " + i);
    }

    private void privateMethod() {

    }

    @Override
    public String toString() {
        return "RefTest{" +
                "publicPro='" + publicPro + '\'' +
                ", protectedPro='" + protectedPro + '\'' +
                ", privatePro='" + privatePro + '\'' +
                '}';
    }
}
