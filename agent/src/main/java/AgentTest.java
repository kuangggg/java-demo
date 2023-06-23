public class AgentTest {

    public void testMethod() {
        try {
            System.out.println("doing biz processing ...");
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
