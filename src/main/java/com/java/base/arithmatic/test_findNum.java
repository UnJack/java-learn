package com.java.base.arithmatic;

import java.util.*;

/**
 * Created by jimjian on 2017/8/1.
 * 两个数相加等于目标值
 */
public class test_findNum {
    public static void main(String[] args) {
        int[] arr = {55, 50, 99, 80, 1, 30, 70};
        Arrays.sort(arr);
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
        //方法一
        findTag(arr, 100);
        //方法二
        System.out.println(sum(arr, 100));
    }

    public static void findTag(int[] arr, int tag) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] > tag) {
                j--;
            } else if (arr[i] + arr[j] < tag) {
                i++;
            } else {
                System.out.println("index =" + i + " ,index =" + j);
                break;
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
