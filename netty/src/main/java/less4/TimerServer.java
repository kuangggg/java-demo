package less4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

/**
 * 解决 less3 粘包问题
 */
public class TimerServer {

    private final int port;

    public TimerServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        new TimerServer(8888).start();
    }

    public void start() throws Exception {

        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap sb = new ServerBootstrap();
            sb.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new StringEncoder());

                            socketChannel.pipeline().addLast(new TimerServerHandler());
                        }
                    });

            ChannelFuture cf = sb.bind().sync();
            System.out.println("netty server started ... ");
            cf.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
