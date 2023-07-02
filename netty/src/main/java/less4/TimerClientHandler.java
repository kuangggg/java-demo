package less4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;

public class TimerClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int counter;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        String newLine = System.getProperty("line.separator");
        String command = "time" + newLine;

        for (int i = 0; i < 100; i++) {
            ctx.writeAndFlush(command);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client received: " + msg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println("client received: read0");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
