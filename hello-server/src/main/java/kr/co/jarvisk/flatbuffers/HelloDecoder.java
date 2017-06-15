package kr.co.jarvisk.flatbuffers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import kr.co.jarvisk.flatbuffers.protocol.Hello;

import java.nio.ByteBuffer;
import java.util.List;

public class HelloDecoder extends ByteToMessageDecoder {

    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        System.out.println("============decode===========");
        int length = byteBuf.readableBytes();
        byte[] bytes = new byte[ length ];

        byteBuf.readBytes(bytes);

        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        Hello hello = Hello.getRootAsHello(byteBuffer);

        list.add(hello);
    }
}
