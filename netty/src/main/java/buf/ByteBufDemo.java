package buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class ByteBufDemo {
    public static void main(String[] args) {
        ByteBuf buf = Unpooled.copiedBuffer("Netty in action", CharsetUtil.UTF_8);

        System.out.println((char) buf.getByte(0));
        System.out.println(buf);

        System.out.println((char) buf.getByte(1));
        System.out.println(buf);

        System.out.println(buf.readByte());
        System.out.println(buf);

        System.out.println(buf.writeByte(55));

        System.out.println(buf.isReadable());
        System.out.println(buf.isWritable());
        System.out.println(buf.isWritable(20));

        System.out.println(buf.readableBytes());
        System.out.println(buf.writableBytes());

        System.out.println(buf.hasArray());

        String s = ByteBufUtil.hexDump(buf);

        System.out.println(s);
    }
}
