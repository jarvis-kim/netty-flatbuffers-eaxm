package kr.co.jarvisk.flatbuffers;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class HelloClient {

    private int serverPort;

    public HelloClient(int serverPort) {
        this.serverPort = serverPort;
    }

    public void run() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        try {
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel sc) throws Exception {
                            sc.pipeline()
                                    .addLast(new LoggingHandler(LogLevel.INFO))
                                    .addLast(new HelloEncoder())
                                    .addLast(new HelloClientHandler());
                        }
                    });

            ChannelFuture cf = b.connect("localhost", serverPort).sync();

            cf.channel().close().channel();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }


    public static void main(String[] args) {
        new HelloClient(7000).run();

    }
}
