package less3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.time.Instant;
import java.time.LocalTime;

@ChannelHandler.Sharable
public class TimerServerHandler extends ChannelInboundHandlerAdapter {

    private int counter;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf bf = (ByteBuf) msg;

        byte[] req = new byte[bf.readableBytes()];
        bf.readBytes(req);
        String body = new String(req);
        System.out.println("server received: " + body);

        String content = "time".equalsIgnoreCase(body) ? LocalTime.now().toString() : "bad command";
        content += System.getProperty("line.separator");

        ByteBuf resp = Unpooled.copiedBuffer(content.getBytes());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
