package com.java.base.arithmatic;

/**
 * Created by jian.jie on 2016/9/1.
 */
public class test_BinarySearch {
    /**
     * 递归方法实现二分查找法.
     *
     * @param arr
     * @param low   数组第一位置
     * @param high  最高
     * @param key   要查找的值.
     * @return 返回值.
     */
    int BinSearch(int[] arr, int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (key == arr[mid])
                return mid;
            else if (key < arr[mid])
                //移动low和high
                return BinSearch(arr, low, mid - 1, key);
            else if (key > arr[mid])
                return BinSearch(arr, mid + 1, high, key);
        } else {
            return -1;
        }
        return low;
    }
}