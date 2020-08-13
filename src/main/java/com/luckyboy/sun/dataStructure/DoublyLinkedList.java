package com.luckyboy.sun.dataStructure;

public class DoublyLinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    public static void main(String[] args) {

        for (int i = 1; i < 1; i++) {
            System.out.println("1111");
        }
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        System.out.println(linkedList);
        System.out.println(linkedList.count);
//        linkedList.remove();
//        System.out.println(linkedList.toString());
        linkedList.add("5");
        linkedList.add("6");
//        linkedList.add(5,"111");
//        System.out.println(linkedList.toString());
//        linkedList.add(1,"222");
//        System.out.println(linkedList.toString());
        linkedList.add(3, "9");
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(3));
//        System.out.println(linkedList.count);
//        linkedList.remove(2);
//        System.out.println(linkedList);
    }

    /**
     * @return
     * @author xieh
     * @date
     */
    public int add(T e) {
        Node<T> node = null;
        if (firstNode == null) {
            node = new Node<>(e, null, null);
            firstNode = node;
            lastNode = node;
        } else {
            if (firstNode.next == null) {
                node = new Node<>(e, firstNode, null);
                firstNode.next = node;
                lastNode = node;
            } else {
                node = new Node<>(e, lastNode, null);
                //把新节点放在当前最后节点的next
                lastNode.next = node;
                //把当前最后节点赋值给新节点的pre
                lastNode = node;
            }
        }
        count++;
        return count;
    }

    /**
     * 增加节点-指定位置
     */
    public int add(int index, T e) {
        checkIndex(index);
        Node<T> node = null;
        if (index == 1) {
            node = firstNode;
            firstNode = new Node<T>(e, null, node.next);
            return ++count;
        } else if (index == count) {
            node = lastNode;
            lastNode = new Node<T>(e, lastNode, null);
            node.next = lastNode;
            return ++count;
        } else if (index < count / 2) {
            node = firstNode;
            for (int i = 1; i < index; i++) {
                node = node.next;
            }

        } else {
            node = lastNode;
            for (int i = 0; i < count - index; i++) {
                node = node.pre;
            }
        }
        Node<T> pre = node.pre;
        Node<T> next = node.next;
        Node<T> newNode = new Node<>(e, node.pre, node.next);
        pre.next = newNode;
        next.pre = newNode;
        return ++count;
    }

    /**
     * 删除节点
     */
    public void remove() {
        if (firstNode == null) throw new RuntimeException("节点为空");
        Node<T> preNode = lastNode.pre;
        lastNode = preNode;
        lastNode.next = null;
        count--;
    }

    /**
     * 删除指定节点
     */
    public void remove(int index) {
        checkIndex(index);
        if (count == 0) {
            firstNode = firstNode.next;
            firstNode.pre = null;
        } else if (count == index) {
            lastNode = lastNode.pre;
            lastNode.next = null;
        } else {
            Node<T> node = firstNode;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            //保留要删除节点的前结点
            Node<T> thisNode = node.pre;
            //把要删除节点的next节点赋值给前结点的next结点
            thisNode.next = node.next;
            //把删除节点的下一个节点的前一个节点指向
            node.next.pre = thisNode;
        }
        count--;
    }


    /**
     * 获取节点
     */
    public T get(int index) {
        checkIndex(index);
        if (index == 1) return firstNode.node;
        if (index == count) return lastNode.node;
        Node<T> node = null;
        if (index <= count / 2) {
            node = firstNode;
            for (int i = 1; i < index; i++) {
                node = node.next;
            }
            return node.node;
        } else {
            node = lastNode;
            for (int i = index; i > 0; i--) {
                node = node.pre;
            }
            return node.node;
        }
    }

    /**
     * 判断index是否异常
     *
     * @param index
     */
    public void checkIndex(int index) {
        if (index < 0) throw new RuntimeException("index不能小于0");
        if (index > count) throw new RuntimeException("index超过数组本身");
    }

    @Override
    public String toString() {
        //定义一个辅助节点，不要改变firstNode的值
        Node<T> node = firstNode;
        StringBuffer buffer = new StringBuffer();
//        if(firstNode != null) {
        while (node.next != null) {
            buffer.append(node.node);
            node = node.next;
        }
        buffer.append(node.node);
        return buffer.toString();
//        }
//        return null;
    }

    class Node<T> {
        private T node;
        Node<T> pre;
        Node<T> next;

        public Node() {
        }

        public Node(T node, Node<T> pre, Node<T> next) {
            this.node = node;
            this.pre = pre;
            this.next = next;
        }

        public T getNode() {
            return node;
        }

        public void setNode(T node) {
            this.node = node;
        }

    }
}
