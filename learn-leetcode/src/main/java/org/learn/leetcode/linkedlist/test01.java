package org.learn.leetcode.linkedlist;

import org.learn.leetcode.common.LinkedListNode;
import org.learn.leetcode.common.TreeNodeFactory;

public class test01 {

    public static void main(String[] args) {
        LinkedListNode<Integer> head = TreeNodeFactory.getLinkedListNode();
        LinkedListNode<Integer> midNode = getMid(head);
        System.out.println(midNode.getData());
    }

    public static LinkedListNode<Integer> getMid(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }
}
