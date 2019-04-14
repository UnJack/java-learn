package com.java.base.arithmatic;

/**
 * Created by jianjie on 2017/8/1.
 */
public class test_LinkList {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addTailNode(114);
        linkList.addHeadNode(111);
        linkList.addHeadNode(112);
        linkList.addHeadNode(113);
        linkList.addHeadNode("11");
        linkList.addHeadNode("12");
        linkList.addHeadNode("13");
        linkList.addHeadNode("14");
        linkList.addTailNode("141");
        linkList.addTailNode("142");
        linkList.display();
    }

    static class LinkList<T> {
        Node head;
        Node tail;
        int length;
        int pos;

        public LinkList() {
            this.head = this.tail = null;
            this.length = 0;
            this.pos = 0;
        }

        //``````````````````````````` start
        public void addHeadNode(String data) {
            Node node = new Node(data);
            if (head == null)
                head = node;
            else {
                node.next = head;
                head = node;
            }
        }

        public void addTailNode(String data) {
            Node node = new Node(data);
            Node pre = head;
            while (pre.next != null) {
                pre = pre.next;
            }
            node.next = pre.next;
            pre.next = node;
        }
        //``````````````````````````` end

        public void addHeadNode(int data) {
            Node p = head;
            Node node = new Node(data);
            if (p == null) {
                tail = node;
            } else {
                node.next = head;
            }
            head = node;
        }

        public void addTailNode(int data) {
            Node p = tail;
            Node node = new Node(data);
            if (p == null) {
                head = node;
            } else {
                p.next = node;
            }
            tail = node;
        }

        public void addPosNode(int i, T data) {
            Node node = new Node(data);
            Node current = head;
            Node previous = head;

            while (pos != i) {
                previous = current;
                current = current.next;
                pos++;
            }
            node.next = current;
            previous.next = node;
            pos = 0;
        }

        public Node delete(T data) {
            Node current = head;
            Node previous = head;
            while (current.data != data) {
                if (current.next == null)
                    return null;
                previous = current;
                current = current.next;
            }
            if (current == head) {
                head = head.next;
            } else {
                previous.next = current.next;
            }
            return current;

        }

        public Node deleteByPos(int index) {
            Node current = head;
            Node previous = head;
            while (pos != index) {
                previous = current;
                current = current.next;
                pos++;
            }
            if (current == head) {
                head = head.next;
            } else {
                pos = 0;
                previous.next = current.next;
            }
            return current;
        }

        public Node deleteByData(T data) {
            Node current = head;
            Node previous = head;
            while (current.data != data) {
                if (current.next == null) {
                    return null;
                }
                previous = current;
                current = current.next;
            }
            if (current == head) {
                head = head.next;
            } else {
                previous.next = current.next;
            }
            return current;
        }

        public Node findByPos(int index) {
            Node current = head;
            if (pos != index) {
                current = current.next;
                pos++;
            }
            return current;
        }

        public Node findByData(T data) {
            Node current = head;
            while (current.data != data) {
                if (current.next == null)
                    return null;
                current = current.next;
            }
            return current;
        }

        public void display() {
            Node node = head;
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    static class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
