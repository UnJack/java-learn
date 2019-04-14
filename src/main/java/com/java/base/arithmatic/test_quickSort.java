package com.java.base.arithmatic;

/**
 * Created by jianjie on 2017/8/7.
 * 快速排序
 */
public class test_quickSort {
    public static void main(String[] args) {
        int a[] = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        sort(a, 0, a.length - 1);

        for (Integer i : a)
            System.out.println(i);
    }

    public static int partition(int[] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            while (array[high] >= key && high > low) {//从后半部分向前扫描
                high--;
            }
            array[low] = array[high];
            while (array[low] <= key && high > low) {//从前半部分向后扫描
                low++;
            }
            array[high] = array[low];
        }
        array[high] = key;
        return high;
    }

    public static void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partition(array, low, high);
        sort(array, low, index - 1);
        sort(array, index + 1, high);
    }
}
