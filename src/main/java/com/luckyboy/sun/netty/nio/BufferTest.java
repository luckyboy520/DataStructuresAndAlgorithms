package com.luckyboy.sun.netty.nio;

import java.nio.IntBuffer;

/**
 * @author xieh
 * @date 2019/12/14 10:55
 */
public class BufferTest {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(5);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i * 2);
        }

        buffer.flip();
        buffer.limit(3);
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
