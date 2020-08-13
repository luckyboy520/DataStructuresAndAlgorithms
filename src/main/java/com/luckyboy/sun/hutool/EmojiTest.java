package com.luckyboy.sun.hutool;

import cn.hutool.extra.emoji.EmojiUtil;

/**
 * @description: 表情测试类
 * @author: LuckyBoy
 * @create: 2020-08-13 10:32
 **/
public class EmojiTest {
    public static void main(String[] args) {
        String alias = EmojiUtil.toAlias("😄");
        String emoji = EmojiUtil.toUnicode(":smile:");

        System.out.println(alias);
        System.out.println(emoji);

    }
}
