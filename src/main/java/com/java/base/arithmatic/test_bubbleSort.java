package com.java.base.arithmatic;

/**
 * Created by jian.jie on 2017/3/14.
 * 冒泡排序
 */
public class test_bubbleSort {
    public static void main(String[] args) {
        int[] n = {23, 5, 668, 224, 1, 7, 3};
        int temp = 0;
        for (int i = 0; i < n.length - 1; i++) {
            for (int j = 0; j < n.length - i - 1; j++) {
                if (n[j] > n[j + 1]) {
                    temp = n[j + 1];
                    n[j + 1] = n[j];
                    n[j] = temp;
                }
            }
        }
        for (int i = 0; i < n.length - 1; i++)
            System.out.println(n[i]);
    }
}
