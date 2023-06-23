package design.factory;

public class MsgFactory {

    public static IMsg getMsgSender(String type) throws Exception {
        if ("im".equals(type)) {
            return new ImMsg();
        }
        throw new Exception("ivalid type");

    }
}
