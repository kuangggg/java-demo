package design.factory;


public class Main {
    public static void main(String[] args) throws Exception {
        MsgFactory.getMsgSender("im").send();
    }
}
