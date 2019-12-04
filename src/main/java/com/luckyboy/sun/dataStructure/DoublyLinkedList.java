package com.luckyboy.sun.dataStructure;

public class DoublyLinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    public static void main(String[] args) {
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        System.out.println(linkedList.toString());
    }


    /**
     * @author xieh
     * @date
     * @return
    */
    public int add(T e) {
        Node<T> node = null;
        if(firstNode == null) {
            node = new Node<>(e, null,null);
            firstNode = node;
            lastNode = node;
        } else {
            node = new Node<>(e,lastNode,null);
            lastNode = node;
        }
        count++;
        return count;
    }

    @Override
    public String toString() {
        //定义一个辅助节点，不要改变firstNode的值
        Node<T> node = firstNode;
        StringBuffer buffer = new StringBuffer();
        while (node.next != null) {
            buffer.append(node.node);
            node = node.next;
        }
        buffer.append(node.node);
        return buffer.toString();
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
