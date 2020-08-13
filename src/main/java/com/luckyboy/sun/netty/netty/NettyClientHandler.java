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
 * @date 2019/12/31 15:02
 * netty-demo 客户端处理器
 */

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    private static final Logger log = LoggerFactory.getLogger(NettyClientHandler.class);

    /**
     * @return
     * @author xieh
     * @date 2019/12/31 15:04
     * 当通道就绪就会触发这个方法
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
        log.info("client is" + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,server", CharsetUtil.UTF_8));
    }

    /**
     * @return
     * @author xieh
     * @date 2019/12/31 15:12
     * 当通道有读取事件时触发
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("service reply message is {}", byteBuf.toString(CharsetUtil.UTF_8));
        log.info("the server address is {}", ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
    }
}
