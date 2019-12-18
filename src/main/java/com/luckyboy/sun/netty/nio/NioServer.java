package com.luckyboy.sun.netty.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xieh
 * @date 2019/12/18 16:40
 * nio的服务端代码实现
 */
@Slf4j
public class NioServer {
    public static void main(String[] args) throws IOException {
        //创建一个serverSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //创建一个选择器，一个选择器可以有多个通道
        Selector selector = Selector.open();
        //绑定一个端口6666，在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        //把通道注册到选择器里面,设置事件为接收
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        log.info("注册后的selectionKey的数量为：{}", selector.keys().size());

        //循环接收客户端的请求
        while (true) {
            //等待一秒，如果没有事件发生则返回
            if(selector.select(1000) == 0) {
                log.info("服务等待了1秒，无连接");
                continue;
            }

            //如果返回的大于0，表示已经去到关注的事件，则获取相关的selectionKey集合
            //然后通过selectionKey反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //打印下目前的selectionKey数量
            log.info("selectionKey数量 = {}", selectionKeys.size());
            //遍历这个集合
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                //判断是什么事件,如果是接收事件，则代表第一次连接
                if(next.isAcceptable()) {
                    //通过通道获取到socketChannel
                    SocketChannel accept = serverSocketChannel.accept();
                    log.info("客户端连接成功，生成一个socketChannel {}", accept.hashCode());
                    accept.configureBlocking(false);

                    //把这个socketChannel注册到选择器，关注事件为OP_READ，同时关联一个buffer
                    accept.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                    log.info("客户端连接后，注册的selectionKey数量 = {}", selector.keys().size());
                }

                if(next.isReadable()) {
                    //通过key反向获取channel
                    SocketChannel channel = (SocketChannel) next.channel();
                    //获取到该channel关联的buffer,这个时候的buffer是没东西的
                    ByteBuffer attachment = (ByteBuffer) next.attachment();
                    //把通道的数据写进buffer里面
                    channel.read(attachment);

                    log.info("from 客户端 {}", new String(attachment.array()));
                }

                //手动从集合中移动当前的selectionKey, 防止重复操作
                iterator.remove();
            }
        }
    }
}
