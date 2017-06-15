package kr.co.jarvisk.flatbuffers;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import kr.co.jarvisk.flatbuffers.protocol.Hello;

import java.nio.ByteBuffer;
import java.util.List;

@ChannelHandler.Sharable
public class WebSocketHelloDecoder extends MessageToMessageDecoder<BinaryWebSocketFrame> {

    protected void decode(ChannelHandlerContext ctx, BinaryWebSocketFrame frame, List<Object> list) throws Exception {
        ByteBuf bb= frame.content();

        System.out.println(ByteBufUtil.hexDump(bb));

        bb.retain();

        ByteBuffer byteBuffer = ByteBuffer.wrap(ByteBufUtil.getBytes(bb));
        Hello hello = Hello.getRootAsHello(byteBuffer);

        list.add(hello);
    }
}
