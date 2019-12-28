package com.luckyboy.sun.netty.nio.groupchat;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author xieh
 * @date 2019/12/28 15:25
 */
@Slf4j
public class GroupchatClient {
    private final String HOST = "127.0.0.1"; // 服务器的ip
    private Selector selector;
    private static Integer SERVER_POST = 6667;
    private SocketChannel socketChannel;
    private String username;

    public GroupchatClient() throws IOException {
        selector = Selector.open();
        socketChannel = socketChannel.open(new InetSocketAddress(HOST, SERVER_POST));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        //得到username
        username = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(username + " is ok...");
    }


    public static void main(String[] args) throws IOException {
        GroupchatClient client = new GroupchatClient();

        //启动一个线程去接收服务端的数据
        new Thread(() -> {
            while (true) {
                try {
                    client.readInfo();
                } catch (IOException e) {
                    log.error("读取服务端数据失败", e);
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.error("读取服务端数据失败", e);
                }
            }
        }).start();

        //发送数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            client.sendInfo(line);
        }
    }
    /**
     * @author xieh
     * @date 2019/12/28 16:03
     * 从服务端读取数据
     * @return
    */
    private void readInfo() throws IOException {
        int readCannels = selector.select();
        if(readCannels > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if(selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    //得到一个buffer
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    channel.read(allocate);

                    log.info("the client receive ： " + new String(allocate.array()));
                }
                //记得删除
                iterator.remove();
            }
        }

    }
    /**
     * @author xieh
     * @date 2019/12/28 16:03
     * 向服务端发送消息
     * @return
    */
    private  void sendInfo(String line) {
        String message = username + " 说：" + line;
        ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes());
        try {
            socketChannel.write(byteBuffer);
        } catch (IOException e) {
            log.error("发送消息异常", e);
        }
    }

}
