package com.luckyboy.sun.JVM;

public class AddAddQuestion {

    public static void main(String[] args) {
        AddAddQuestion question = new AddAddQuestion();
        question.add();
    }

    public void add() {
        //第一类问题
        int a = 10;
        a++;
        System.out.println("a = " + a);
        int b = 10;
        ++b;

        //第二类问题
        int c = 10;
        int d = c++;

        int e = 10;
        int f = ++e;

        //第三类问题
        int g = 10;
        g = g++;

        int h = 10;
        h = ++h;

        //第四类问题
        int i = 10;
        int j = i++ + ++i;
    }
}
