package com.example.test;

import lombok.Data;

/**
 * TODO
 *
 * @author hui.xie
 * @date 2025/5/22 14:36
 */
public class RecordPatternsTest {
    public static void main(String[] args) {
        test("HELLO");
        /**
         * 1.简化数据提取和类型匹配，之前我们要instanceof之后强转，但是现在不需要
         */
        //也可以new出来的
        PointT pointT = new PointT(1, 2);

    }


    public static void test(Object o) {
        //JDK16之后
        if (o instanceof String p) { 
            System.out.println(p.charAt(0));
        }
        //JDK16之前
        if (o instanceof String) {
            String p = (String) o;
            System.out.println(p.charAt(1));
        }

    }
}
@Data
class Point {
    private int x;
    private int y;

/*    //JDK16之前
    static void printSum(Object obj) {
        if (obj instanceof Point) {
            Point p = (Point) obj;
            int x = p.getX();
            int y = p.getY();
            System.out.println(x + y);
        }
    }

    //JDK16之后
    static void printSumT(Object obj) {
        if (obj instanceof PointT p) {
            int x = p.x();
            int y = p.y();
            System.out.println(x+y);
        }
    }*/

    //JDK21之后
    static void printSumR(Object obj) {
        if (obj instanceof PointT(int x, int y)) {
            System.out.println(x+y);
        }
    }
}


//JDK16之后
record PointT (int x, int y) {}
