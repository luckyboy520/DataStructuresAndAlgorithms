package com.luckyboy.sun.java8;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @description: 流测试类
 * @author: LuckyBoy
 * @create: 2020-09-15 15:18
 **/
public class StreamTest {
    public static void main(String[] args) {
        // reduce 规约测试
        Optional<String> reduce = Arrays.asList("1", "2", "3").stream().reduce((one, two) -> one + "#" + two);
        reduce.ifPresent(System.out::println);

        //链接字符串
        String reduce1 = Stream.of("1", "2", "3", "4").reduce("#", String::concat);
        System.out.println(reduce1);
    }
}
