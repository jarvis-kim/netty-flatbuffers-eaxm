package kr.co.jarvisk.flatbuffers;

import com.google.flatbuffers.FlatBufferBuilder;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import kr.co.jarvisk.flatbuffers.protocol.Hello;

import java.nio.ByteBuffer;

@ChannelHandler.Sharable
public class HelloClientHandler extends ChannelInboundHandlerAdapter {

    public Hello hello() {
        FlatBufferBuilder fbb = new FlatBufferBuilder(1);

        int messageOffset = fbb.createString("hello server.");
        int nameOffset = fbb.createString("jarvis");

        Hello.startHello(fbb);
        Hello.addMessage(fbb, messageOffset);
        Hello.addName(fbb, nameOffset);
        Hello.addCount(fbb, 3);
        int endOffset = Hello.endHello(fbb);
        Hello.finishHelloBuffer(fbb, endOffset);
        byte[] packet = fbb.sizedByteArray();

        Hello hello = Hello.getRootAsHello(ByteBuffer.wrap(packet));
        hello.getByteBuffer().array();

        return hello;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Hello hello = hello();
        ctx.write(hello);
        ctx.flush();
    }
}
