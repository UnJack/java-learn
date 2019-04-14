package com.java.base.arithmatic;

/**
 * Created by jian.jie on 2017/3/14.
 * 插入排序最差n2，平均时间复杂度n*log2n
 */
public class test_insertSort {
    public static void main(String[] args) {
        int[] n = {2, 3, 3, 6, 8, 44, 22, 66, 5};
        int temp = 0;
        for (int i = 1; i < n.length; i++) {
            int j = i - 1;
            temp = n[i];
            for (; j >= 0 && temp < n[j]; j--) {
                n[j + 1] = n[j];
            }
            n[j + 1] = temp;
        }

        for (int i = 0; i < n.length; i++)
            System.out.println(n[i]);
    }

}
