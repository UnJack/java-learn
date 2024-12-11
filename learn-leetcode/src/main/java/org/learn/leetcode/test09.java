package org.learn.leetcode;

public class test09 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -12333, 12333, 22, 0, -1};
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num - min > max) {
                max = num - min;
            }
        }
        System.out.println("max = " + max);
    }
}