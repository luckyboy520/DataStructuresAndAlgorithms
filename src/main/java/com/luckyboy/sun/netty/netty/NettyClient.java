package com.luckyboy.sun.netty.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xieh
 * @date 2019/12/31 14:55
 * netty-demo客户端
 */

public class NettyClient {
    private static final Logger log = LoggerFactory.getLogger(NettyClient.class);

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();

        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyClientHandler());
                        }
                    });

            log.info("client is ok");

            //连接服务器的端口和地址
            ChannelFuture sync = bootstrap.connect("127.0.0.1", 6668).sync();
            //给关闭通道进行监听
            sync.channel().closeFuture().sync();

        } catch (Exception e) {
            log.error("异常捕捉", e);
        } finally {
            group.shutdownGracefully();
        }
    }
}
