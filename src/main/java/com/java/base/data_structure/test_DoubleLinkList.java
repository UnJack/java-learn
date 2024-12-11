package com.java.base.data_structure;

/**
 * Created by jimjian on 2017/7/27.
 */
public class test_DoubleLinkList {

    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        doubleLinkList.addHeadNode("A1");
        doubleLinkList.addHeadNode("A2");
        doubleLinkList.addHeadNode("A3");
        doubleLinkList.addHeadNode("A4");
        doubleLinkList.addTailNode("A5");
        doubleLinkList.display();
        doubleLinkList.getLength();
    }

    static class DoubleLinkList<T> {
        // 头结点
        Node<T> head;
        // 尾节点
        Node<T> tail;
        int length;

        DoubleLinkList() {
        }

        /**
         * 头部插入
         *
         * @param data
         */
        public void addHeadNode(T data) {
            Node node = new Node(data);
            if (tail == null) {
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
            }
            length++;
            head = node;
        }

        /**
         * 尾部插入
         *
         * @param data
         */
        public void addTailNode(T data) {
            Node node = new Node(data);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
            }
            length++;
            tail = node;
        }

        /**
         * 输出
         */
        public void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println();
        }

        public void getLength() {
            System.out.println("length=" + length);
        }
    }

    static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private T data;

        Node(T data) {
            this.data = data;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
