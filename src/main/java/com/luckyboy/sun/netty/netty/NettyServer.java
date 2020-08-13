package com.luckyboy.sun.netty.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xieh
 * @date 2019/12/31 10:49
 * netty服务端代码demo
 */

public class NettyServer {
    private static final Logger log = LoggerFactory.getLogger(NettyServer.class);

    /**
     * netty总包括两个线程组，Bossgroup和workerGroup
     * Bossgroup只负责处理接收请求，workerGroup才是真正处理客户端的请求
     * 两个都是无限循环
     * 他们的子线程个数都是cpu内核数*2
     */
    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {

            //使用链式编程进行设置
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) //使用NioSocketChannel作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128) //设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) //设置保持活动的连接状态
//                .handler(null) // 管道的处理器，handler对应bossGroup，childHandler对应workerGroup
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            log.info("客户socketChannel 的hascode = {}", ch.hashCode());
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });//给workerGroup对应的每个EventLoop对应的管道设置处理器

            log.info("==============server is ready================");

            //绑定一个端口并且同步返回channelFuture对象
            ChannelFuture cf = serverBootstrap.bind(6668).sync();

            //可以给cf注册监听器，监听想关心的事件
            cf.addListener((x) -> {
                if (x.isSuccess()) {
                    log.info("监听端口 6668 成功");
                } else {
                    log.info("监听端口6668 失败");
                }
            });

            //对关闭通道进行监听
            cf.channel().closeFuture().sync();

        } catch (Exception e) {
            log.error("异常捕捉", e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
