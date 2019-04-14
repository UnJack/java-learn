package com.java.base.arithmatic;

import java.util.NoSuchElementException;

/**
 * Created by jianjie on 2017/7/27.
 * https://yq.aliyun.com/articles/48908
 */
public class test_DoubleLinkList {

    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        doubleLinkList.addHeadTail("A1");
        doubleLinkList.addHeadTail("A2");
        doubleLinkList.addHeadTail("A3");
        doubleLinkList.addHeadTail("A4");
        doubleLinkList.addTailNode("B1");
        doubleLinkList.addTailNode("B2");
        doubleLinkList.addTailNode("B3");
        doubleLinkList.addTailNode("B4");
        doubleLinkList.display();
        doubleLinkList.getLength();
        doubleLinkList.getHeadData();
        doubleLinkList.getTailData();
    }

    static class DoubleLinkList<T> {
        // 头结点
        Node<T> head;
        // 尾节点
        Node<T> tail;
        int length;

        DoubleLinkList() {
            this.head = this.tail = null;
            this.length = 0;
        }

        //头插入
        public void addHeadTail(T data) {
            Node p = head;
            Node node = new Node(null, data, p);
            if (p == null) {
                tail = node;
            } else {
                node.previous = head;
            }
            head = node;
            length++;
        }

        //尾插入
        public void addTailNode(T data) {
            Node<T> p = tail;
            Node node = new Node(p, data, null);
            if (p == null) {
                head = node;
            } else {
                p.next = node;
            }
            tail = node;
            length++;
        }

        public void getHeadData() {
            Node node = head;
            if (node == null)
                throw new NoSuchElementException();
            System.out.println("头节点:" + node.data);
        }

        public void getTailData() {
            Node node = tail;
            if (node == null)
                throw new NoSuchElementException();
            System.out.println("尾节点:" + node.data);
        }

        public void display() {
            Node node = head;
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }

        public void getLength() {
            System.out.println("length:" + this.length);
        }

    }

    static class Node<T> {
        private Node<T> previous;
        private Node<T> next;
        private T data;

        Node(Node<T> previous, T data, Node<T> next) {
            this.previous = previous;
            this.next = next;
            this.data = data;
        }
    }
}
