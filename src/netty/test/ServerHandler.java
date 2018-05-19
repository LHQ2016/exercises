package netty.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class ServerHandler extends ChannelHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf buf = (ByteBuf) msg;
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req, "utf-8");
            System.out.println("Server : " + body);
            String response = "返回给客户端的响应：" + body;
            ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));


        } finally {
            ReferenceCountUtil.release(msg);
        }
      /*
        ByteBuf in = (ByteBuf)msg;
        try{
            System.out.println(in.toString(CharsetUtil.UTF_8));
        }finally{
            ReferenceCountUtil.release(msg);
        }
        */
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
