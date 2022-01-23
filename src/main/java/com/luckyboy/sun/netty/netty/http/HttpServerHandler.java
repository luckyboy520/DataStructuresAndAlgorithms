package com.luckyboy.sun.netty.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 * @author xieh
 * @date 2019/12/31 15:37
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    private static final Logger log = LoggerFactory.getLogger(HttpServerHandler.class);

//    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        if (msg instanceof HttpRequest) {
            log.info("ctx的类型：{}", ctx.getClass());
            log.info("pipeline hascode is {}", ctx.pipeline().hashCode());
            log.info("msg的类型是: {}", msg.getClass());
            log.info("客户端地址：{}", ctx.channel().remoteAddress());

            HttpRequest request = (HttpRequest) msg;
//            URI uri = new URI(request.uri());
//            if ("/favicon.ico".equals(uri.getPath())) {
//                log.info("获取页面图标不处理请求~~~~~~~~~");
//                return;
//            }
            ByteBuf byteBuf = Unpooled.copiedBuffer("hello,luckyboy server", CharsetUtil.UTF_8);
            //构造一个httpresponse
            FullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
//            defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
//            defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());

            //构建后并返回
            ctx.writeAndFlush(defaultFullHttpResponse);

        }

    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

    }
}
