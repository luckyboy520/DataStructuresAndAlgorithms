package com.luckyboy.sun.JVM;

/**
 * ---------------------------------------
 * 类的初始化阶段遇到下面6中情况就会执行
 * 1.遇到new，getstatic，pubstatic，invokestatic指令，如果还没初始化就会执行
 *    ①new对象的时候
 *    ②读取一个类静态字段或者静态方法（除final修饰外，因为在编译期就确定了）
 * 2.使用反射的时候（如果类还没初始化）
 * 3.初始化子类时，先初始化父类
 * 4.当虚拟机启动时，指定的主类初始化（如：main方法）
 * 5.JDK7加入动态语言支持后，解析结果有REF_getStatic、REF_putStatic、REF_invokeStatic、REF_newInvokeSpecial
 *   这四个句柄时，也会初始化
 * 6.JDK8：当一个类实现了含有默认方法的接口时，这个接口也会实例化
 *
 * ------------------以上叫主动引用----------------------
 *
 * *************************不是主动引用的就叫被动引用***************************
 * ①如下面的父子类，子类调用父类的静态字段或静态方法，则子类不是被初始化
 *   但是子类会被加载
 * ②
 * */

public class Initialazation {
    public static String one = "11";

    static {
        System.out.println("父类加载了");
    }

    public static void one() {
        System.out.println("父类静态方法加载了");
    }

    public static void main(String[] args) {
        son.one();
    }

}

class son extends Initialazation {
    static {
        System.out.println("子类加载了吗");
    }

}