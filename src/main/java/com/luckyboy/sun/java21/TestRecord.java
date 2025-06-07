package com.luckyboy.sun.java21;

public record TestRecord(int x, int y) {
    public static void main(String[] args) {
        TestRecord testRecord = new TestRecord(1, 2);
        System.out.println(testRecord.x());
        System.out.println(testRecord.y());
    }
}
