package org.learn.leetcode.common;

import lombok.Data;

@Data
public class LinkedListNode<T> {

    private LinkedListNode<T> next;
    private T data;

    public LinkedListNode(T data) {
        this.data = data;
    }

    public LinkedListNode(LinkedListNode<T> next, T data) {
        this.next = next;
        this.data = data;
    }
}
