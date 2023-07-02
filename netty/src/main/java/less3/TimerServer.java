package less3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

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
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
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
