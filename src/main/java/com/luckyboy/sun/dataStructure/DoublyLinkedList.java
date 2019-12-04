package com.luckyboy.sun.dataStructure;

public class DoublyLinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;


    /**
     * @author xieh
     * @date
     * @return
    */
    public int add(T e) {
        return 0;
    }


    class Node<T> {
        private T node;
        Node<T> pre;
        Node<T> next;

        public Node(T node, Node<T> pre,Node<T> next) {
            this.node = node;
            this.next = next;
        }

        public T getNode() {
            return node;
        }

        public void setNode(T node) {
            this.node = node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "node=" + node +
                    ", pre=" + pre +
                    ", next=" + next +
                    '}';
        }
    }
}
