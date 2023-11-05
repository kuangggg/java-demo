package design.factory;

public class ImMsg implements IMsg {
    @Override
    public void send() {
        System.out.println("im msg sender");
    }
}
