package com.luckyboy.sun.java8;

import java.util.Arrays;
import java.util.Optional;

/**
 * @description: Optional的test
 * @author: LuckyBoy
 * @create: 2020-09-15 11:42
 **/
public class OptionalTest {

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(getName(null));
        System.out.println(getNameT(null));
        User user = new User();
//        User user = null;
        A a = new A();
        B b = new B();
        C c = new C();
        c.setC("2222");
        a.setB(b);b.setC(c);
        user.setA(a);

        System.out.println(getB(user));
        System.out.println(getBT(user));

    }
    /**
     * 使用optional之前
     * @param user
     * @return: java.lang.String
     * @Author: LuckyBoy
     * @date: 2020-09-15 14:24
     */
    public static String getName(User user) {
        if(user == null || user.getName() == null) {
            return "unknow";
        }
        return user.getName();
    }

    /**
     * 使用optional之后
     * @param user
     * @return: java.lang.String
     * @Author: LuckyBoy
     * @date: 2020-09-15 14:24
     */
    public static String getNameT(User user) {
        return Optional.ofNullable(user)
                .map(User::getName)
                .orElse("unknow");
    }
    /**
     * 使用Optional之前的层层判断
     * @param user
     * @return: java.lang.String
     * @Author: LuckyBoy
     * @date: 2020-09-15 14:26
     */
    public static String getB(User user) throws IllegalAccessException {
        if(user != null) {
            A a = user.getA();
            if(a != null) {
                B b = a.getB();
                if(b != null) {
                    C c = b.getC();
                    if(c != null) {
                        return c.getC();
                    }
                }
            }
        }
        throw new IllegalAccessException("这个值不存在啊");
    }


    /**
     * 使用Optional之后的层层判断
     * @param user
     * @return: java.lang.String
     * @Author: LuckyBoy
     * @date: 2020-09-15 14:26
     */
    public static String getBT(User user) throws IllegalAccessException {
        return Optional.ofNullable(user)
                .map(User::getA)
                .map(A::getB)
                .map(b -> b.getC().getC())
                .orElseThrow(() -> new IllegalAccessException("这个值不存在啊"));
    }
}
