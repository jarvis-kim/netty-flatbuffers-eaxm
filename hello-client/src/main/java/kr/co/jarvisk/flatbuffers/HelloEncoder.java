package kr.co.jarvisk.flatbuffers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import kr.co.jarvisk.flatbuffers.protocol.Hello;

@ChannelHandler.Sharable
public class HelloEncoder extends MessageToByteEncoder<Hello> {


    protected void encode(ChannelHandlerContext ctx, Hello hello, ByteBuf byteBuf) throws Exception {
        byteBuf.writeBytes(hello.getByteBuffer().array());
        ctx.flush();
    }
}
