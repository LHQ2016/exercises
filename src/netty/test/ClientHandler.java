package netty.test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf rec = (ByteBuf) msg;
        try {
            //buf.toString(CharsetUtil.UTF_8)表示将ByteBuf类型的buf以utf-8编码转换为字符串
            System.out.println(rec.toString(CharsetUtil.UTF_8));
//            ctx.writeAndFlush(Unpooled.copiedBuffer("hello ,netty ".getBytes()));
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
