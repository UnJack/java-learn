package org.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimjian on 2020-03-15.
 * 斐波那契
 */
public class test_fibonacciSequence {

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        for (Integer integer : fibonacci$(9)) {
            System.out.print(integer + " ");
        }

    }

    /**
     * 递归
     * @param num
     * @return
     */
    public static int fibonacci(int num) {
        if (num < 0) {
            return -1;
        }
        if (num == 0 || num == 1) {
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    /**
     * 非递归
     * @param num
     * @return
     */
    public static List<Integer> fibonacci$(int num) {
        if (num < 0) {
            return null;
        }
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(1);
        for (int i = 2; i < num; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        return list;
    }
}
