package com.luckyboy.sun.dataStructure;
/**
 * 链表是已节点的形式存储的，不一定是顺序存储
 * 链表的每一个节点都有指定上或者下一个节点的Node
 *
 * **/
public class SingleList<T> {

    //第一个元素
    private Node<T> firstNode;
    //最后一个元素
    private Node<T> lastNode;
    //容器大小
    private int count;

    public static void main(String[] args) {
        SingleList<String> singleList = new SingleList<>();
        singleList.add("1");
        singleList.add("2");
        singleList.add("3");
        singleList.add("4");
        singleList.add("5");
        singleList.add("6");

        System.out.println(singleList.add("7"));
        System.out.println(singleList.toString());
        System.out.println("========remove start========");
        singleList.removeIndex(0);
        System.out.println("========remove end=========");
        System.out.println(singleList.toString());
        System.out.println(singleList.get(0));
        System.out.println(singleList.replace("111",5));
        System.out.println(singleList.toString());
    }

    /**
     * 增加节点
     * */
    public int add(T e) {
        //如果开始不存在，则新建
        Node node = new Node<T>(e, null);
        if(firstNode == null) {
            firstNode = node;
            lastNode = node;
        }
        //获取当前last
        lastNode.next = node;
        lastNode = node;
        count++;
        return count;
    }

    /**
     * 删除节点
     * */
    public void remove() {
        //把最后一个节点删除，然后前一个节点的next为null
        //因为是单节点，所有lastNode在这里没用
        //这里应该还需要用count来处理下，因为需要获取当前最后一个节点的上一个节点
        //建立一个辅助节点(最后一个节点的上一个节点)
        Node<T> node = firstNode;
        for(int i =1;i < count -1; i++) {
            node = node.next;
        }
        node.next = null;
        lastNode = node;
        count--;
    }
    /**
     * 删除节点-指定节点
     * @param index
     * 这里其实存在几种情况
     * 假如index是0，则把firstNode改变
     * 如果是中间位置，或者改变它的前节点和后节点的相关
     * 如果是最后位置，跟remove一样
     * */
    public void removeIndex(int index) {
        checkIndex(index);
        Node<T> node = firstNode;
        Node<T> thisNode=null;
        if(index == 0) {
            firstNode = node.next;
        } else if(index == count) {
            this.remove();
        }
        //获取当前删除节点的上一个节点
        for(int i =1;i < index -1; i++) {
            node = node.next;
        }
        //获取当前删除节点的下一个节点
        thisNode = node.next.next;
        node.next = thisNode;
        count--;
    }

    /**
     * 获取节点
     * @param index
     * */
    public T get(int index) {
        checkIndex(index);
        if(index == 0) return firstNode.node;
        if(index == count) return lastNode.node;
        Node<T> node = firstNode;
        for(int i = 0; i < index -1; i++) {
            node = node.next;
        }
        return node.node;
    }
    /**
     * 修改节点
     * @param e 节点值
     * @param index 替换位置
     *
     * */
    public T replace(T e, int index) {
        checkIndex(index);
        //替换之前的元素
        T replace = null;
        if (index == 0) {
            replace = firstNode.node;
            firstNode.node = e;
        }
        if (index == count) {
            replace = firstNode.node;
            lastNode.node = e;
        }
        Node<T> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        replace = node.node;
        node.node = e;
        return replace;
    }
    /**
     * 判断index是否异常
     * @param index
     * */
    public void checkIndex(int index) {
        if(index < 0) throw new RuntimeException("index不能小于0");
        if(index > count) throw new RuntimeException("index超过数组本身");
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
        Node<T> next;

        public Node(T node, Node<T> next) {
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
                    ", next=" + next +
                    '}';
        }
    }


}
