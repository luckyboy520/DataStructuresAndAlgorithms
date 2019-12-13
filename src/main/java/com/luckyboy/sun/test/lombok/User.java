package com.luckyboy.sun.test.lombok;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author xieh
 * @date 2019/12/13 14:53
 * lombok的Accessors注解的链式表达
 * chain为true则返回对象本身
 * chain为false则没有返回
 */
@Data
@Accessors(chain = true)
public class User {
    private String name;
    private Integer age;

    public static void main(String[] args) {
        System.out.println(new User().setAge(11).setName("hah").toString());
    }
}
