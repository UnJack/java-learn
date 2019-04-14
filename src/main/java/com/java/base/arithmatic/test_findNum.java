package com.java.base.arithmatic;

import java.util.*;

/**
 * Created by jianjie on 2017/8/1.
 * 两个数相加等于目标值
 */
public class test_findNum {
    public static void main(String[] args) {
        int[] a = {55, 50, 99, 80, 1, 30, 70};
        Arrays.sort(a);
        findSumTo100(a, a.length);
        System.out.println(sum(a, 100));
    }

    public static void findSumTo100(int a[], int n) {
        for (int i = 0, j = n - 1; i != j; ) {
            int num = a[i] + a[j];
            if (num == 100) {
                System.out.println(a[i] + "," + a[j]);
                i++;
                j--;
            } else if (num < 100) {
                i++;
            } else if (num > 100) {
                j--;
            }
        }
    }

    public static Map sum(int[] numbers, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        System.out.println(map);
        for (int i = 0; i < numbers.length; i++) {
            int value = target - numbers[i];
            if (map.containsKey(value) && map.get(value) != i) {
                int index = map.get(value);
                if (index < i)
                    result.put(index, i);
            }
        }
        return result;
    }

}
