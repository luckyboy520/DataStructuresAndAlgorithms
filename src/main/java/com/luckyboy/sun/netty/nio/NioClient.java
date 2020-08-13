package com.luckyboy.sun.netty.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author xieh
 * @date 2019/12/18 17:43
 */
public class NioClient {
    private static final Logger log = LoggerFactory.getLogger(NioClient.class);

    public static void main(String[] args) throws IOException {
        //创建一个SocketChannel
        SocketChannel open = SocketChannel.open();
        open.configureBlocking(false);
        //绑定服务器的ip和端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        //连接服务器，如果连接失败
        if (!open.connect(inetSocketAddress)) {
            while (!open.finishConnect()) {
                log.info("因为连接需要时间，客户端不会阻塞，可以做其他工作..");
            }
        }
        //如果连接成功则直接发数据
        String str = "啊哈哈哈，luckyboy~";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());

        open.write(byteBuffer);

        System.in.read();
    }
}
