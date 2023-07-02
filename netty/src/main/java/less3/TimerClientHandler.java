package less3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class TimerClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int counter;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        String newLine = System.getProperty("line.separator");
        String command = "time" + newLine;

        byte[] req = command . getBytes();

        for (int i = 0; i < 100; i++) {
            ByteBuf msg = Unpooled.buffer(req.length);
            msg.writeBytes(req);

            ctx.writeAndFlush(msg);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        System.out.println("client received: " + byteBuf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
