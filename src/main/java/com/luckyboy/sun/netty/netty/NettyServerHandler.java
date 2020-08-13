package com.luckyboy.sun.netty.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xieh
 * @date 2019/12/31 14:31
 * 自定义一个handel处理客户端请求的数据，需要继承netty规定好的某个handlerAdapter
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger log = LoggerFactory.getLogger(NettyServerHandler.class);

    /**
     * @return
     * @author xieh
     * @date 2019/12/31 14:33
     * 获取客户端发送过来的消息
     * 1.ctx就是上下文对象，有管道pipeline，通道channel，地址
     * 2.msg就是发送的内容
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("服务器读取线程 {}, channel是 {}", Thread.currentThread().getName(), ctx.channel());
        log.info("上下文对象 {}", ctx);
        log.info("看看channel和pipeline的关系");

        //channel和pipeline的关系，双向包含
        ByteBuf buf = (ByteBuf) msg;
        log.info("client sends a message is {}", buf.toString(CharsetUtil.UTF_8));
        log.info("client address is {}", ctx.channel().remoteAddress());

    }

    /**
     * @return
     * @author xieh
     * @date 2019/12/31 14:51
     * 数据读取完成后的回复
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~~1", CharsetUtil.UTF_8));
    }

    /**
     * @return
     * @author xieh
     * @date 2019/12/31 14:53
     * 处理异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
