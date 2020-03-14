package com.java.base.data_structure;

/**
 * Created by JianJie on 2017/6/27.
 * 数组实现栈
 */
public class test_Stack {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");
        s.push("6");
        s.push("7");
        s.push("8");
        s.push("9");
        s.push("10");
        System.out.println(s.pop());
        for (Object o : s.array) {
            System.out.println("o = " + o);
        }
        s.getMin();
    }

    static class Stack<T> {
        private T[] array;
        private int size;
        private int top = -1;
        private int minNum;

        public Stack() {
            this.array = (T[]) new Object[10];
            this.minNum = 0;
        }

        public Stack(int size) {
            array = (T[]) new Object[size];
        }

        public void push(T data) {
            if (array.length == size) {
                reSize(size * 2);
            }
            size++;
            array[++top] = data;
            if (top == 0)
                minNum = Integer.parseInt((String) data);
            if (minNum > Integer.parseInt((String) data))
                minNum = Integer.parseInt((String) data);
        }

        public T pop() {
            if (isEmpty()) return null;
            size--;
            return array[top--];
        }

        private boolean isEmpty() {
            return this.top == -1;
        }

        private void reSize(int size) {
            T[] old = array;
            array = (T[]) new Object[size];
            for (int i = 0; i < old.length; i++) {
                array[i] = old[i];
            }
        }

        public void getMin() {
            System.out.println("min:" + minNum);
        }
    }
}
