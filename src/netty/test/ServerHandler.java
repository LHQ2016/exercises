package netty.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class ServerHandler extends ChannelHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        try {
//            byte[] req = new byte[buf.readableBytes()];
//            buf.readBytes(req);
//            String body = new String(req, "utf-8");
//            System.out.println("Server : " + body);
            //以上四句相当于下面这一句
            // buf.toString(CharsetUtil.UTF_8)表示将ByteBuf类型的buf以utf-8编码转换为字符串
            System.out.println("Server : " + buf.toString(CharsetUtil.UTF_8));
            String response = "返回给客户端的响应：" + buf.toString(CharsetUtil.UTF_8);
            ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes())).addListener(ChannelFutureListener.CLOSE);
            //addListener(ChannelFutureListener.CLOSE)永远是在服务器端进行关闭，以防止client接收不到服务器返回的数据

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
