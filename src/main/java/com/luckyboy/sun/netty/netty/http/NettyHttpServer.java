package com.luckyboy.sun.netty.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xieh
 * @date 2019/12/31 15:18
 * netty基于http协议的服务端，客户端为浏览器
 */
public class NettyHttpServer {
    private static final Logger log = LoggerFactory.getLogger(NettyHttpServer.class);

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HttpServerInitializer());

            ChannelFuture sync = serverBootstrap.bind(7777).sync();
            log.info("==============server is ready================");

            sync.channel().closeFuture().sync();
        } catch (Exception e) {
            log.error("异常捕捉", e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
