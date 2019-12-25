package com.luckyboy.sun.netty.nio.groupchat;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author xieh
 * @date 2019/12/19 11:06
 * 简单聊天室设计思路
 *   一.服务端要知道谁上线了，谁下线了，消息的转发排除自己的消息转发给其他客户端）
 *
 *
 */
@Slf4j
public class GroupchatServer {
    private Selector selector = Selector.open();
    private static Integer SERVER_PORT = 6667;
    private ServerSocketChannel serverSocketChannel;

    public GroupchatServer() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);
        //绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(SERVER_PORT));
        //注册到选择器
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    }
    /**
     * @author xieh
     * @date 2019/12/25 14:43
     * 监听事件发生
     * @return
    */
    public void listen() throws IOException {
        log.info("监听线程：", Thread.currentThread().getName());

        //从选择器获取是否有通道,大于0则代表有事件处理
        if(selector.select() > 0) {
            //获取所有selecctionKey
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                //判断是什么事件，如果是接收事件，第一次默认都是接收事件
                if(selectionKey.isAcceptable()) {
                    //因为第一次还没有创建通道，需要通过serverChannel创建
                    SocketChannel accept = serverSocketChannel.accept();
                    //设置为非阻塞
                    accept.configureBlocking(false);
                    //把这个通道注册到选择器，设置为读
                    accept.register(selector, SelectionKey.OP_READ);
                    //提示下是哪个客户端上线了
                    log.info("客户端：{}，上线", accept.getRemoteAddress());
                }

                //如果是可读事件，就是客户端发送数据过来
                if(selectionKey.isReadable()) {
                    readData(selectionKey);
                }


            }
        }
    }
    /**
     * @author xieh
     * @date 2019/12/25 16:44
     * 读取文件数据
     * @return
    */
    private void readData(SelectionKey selectionKey)  {
        SocketChannel channel = null;
        try {
            //通过selectionKey反向获取channel
            channel = (SocketChannel) selectionKey.channel();
            //创建buffer，从通道的数据需要放进buffer中
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            int count = channel.read(byteBuffer);
            //大于零表示读到了数据
            if (count > 0) {
                String msg = new String(byteBuffer.array());
                log.info("from client is ：{}", msg);

                //把消息转发给其他客户端
                sendInfoToOtherClients(msg, channel);
            }
        } catch (IOException e) {
            try {
                log.info("{} 离线了", channel.getRemoteAddress());
                //取消注册
                selectionKey.cancel();
                //关闭通道
                channel.close();
                log.error("读取通道数据异常", e);
            } catch (IOException ex) {
                log.error("获取通道地址异常", ex);
            }
        }
    }
    /**
     * @author xieh
     * @date 2019/12/25 16:59
     * 将消息转发给其他客户端，过滤掉自己
     * @return
    */
    private void sendInfoToOtherClients(String msg, SocketChannel channel) {
        log.info("服务器转发消息中...");
        log.info("服务器转发数据给客户端线程: {}" , Thread.currentThread().getName());
        //遍历所有的通道判断是否是该客户端本身
        selector.keys().forEach(selectionKey -> {
            //获取通道
            SocketChannel channel1 = (SocketChannel) selectionKey.channel();
            if(channel1 instanceof SocketChannel && channel1 != channel) {
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                try {
                    channel1.write(byteBuffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public static void main(String[] args) {
        try {
            GroupchatServer groupchatServer = new GroupchatServer();
            groupchatServer.listen();
        } catch (IOException e) {
            log.error("nio server 异常", e);
        }
    }
}
