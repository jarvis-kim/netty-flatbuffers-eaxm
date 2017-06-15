package kr.co.jarvisk.flatbuffers;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import kr.co.jarvisk.flatbuffers.protocol.Hello;

@ChannelHandler.Sharable
public class HelloHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if ( msg instanceof Hello ) {
            Hello hello = (Hello) msg;

            int count = hello.count();
            String name = hello.name();
            String message = hello.message();

            for ( int i = 0; i < count; i++ ) {
                System.out.println("from : " + name  + ", message : " + message);
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        ctx.flush();
    }
}
