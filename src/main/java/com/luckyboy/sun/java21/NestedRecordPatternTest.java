package com.luckyboy.sun.java21;

/**
 * 嵌套模式,
 */
public class NestedRecordPatternTest {
    public static void main(String[] args) {
        test2(new Rectangle(new ColorPoint(new Point(1, 2), Color.RED), new ColorPoint(new Point(3, 4), Color.BLUE)));
    }

    static void test(Object o) {
        if(o instanceof Rectangle (ColorPoint topLeft, ColorPoint bottomRight)) {
            System.out.println(topLeft.color());
        }
    }

    static void test2(Object o) {
        //这里不能用Point（1,2），只是做形参
        if(o instanceof Rectangle (ColorPoint(Point p, Color c), ColorPoint(Point p1, Color c1))) {
            System.out.println(p.x() + " " + p.y() + " " + c);
        }
    }
}

record Point (int x, int y) {}
enum Color {
    RED, GREEN, BLUE
}
record ColorPoint (Point point, Color color) {}
record Rectangle (ColorPoint topLeft, ColorPoint bottomRight){}

//泛型记录模式
record Pair<S, T> (S s, T t) {}