package com.luckyboy.sun.dataStructure;

import java.util.Stack;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-10-27 11:09
 **/
public class MyQueue<T> {
    private Stack<T> pop;
    private int index;
    private int popIndex;
    /**
     * 可以在初始化的时候赋值初始值，这样可以知道最大值
     * */
    public MyQueue() {
        pop = new Stack<>();
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        myQueue.push(6);

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

    }

    public T push (T e) {
        T push = pop.push(e);
        index++;
        return push;
    }

    public T pop() {
        if(popIndex >= index) {
            return null;
        }
        T t = pop.elementAt(popIndex);
        popIndex++;
        return t;
    }
}
