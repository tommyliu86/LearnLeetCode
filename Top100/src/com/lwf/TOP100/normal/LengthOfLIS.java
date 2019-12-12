package com.lwf.TOP100.normal;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-12-12 Time: 09:40
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        return recursive(nums, Integer.MIN_VALUE, 0, 0);
    }

    /**
     * 暴力法，直接递归回溯求最大上升，使用k>k-1的比较进行max+1计算
     * @param nums
     * @param lastelement
     * @param index
     * @param maxlength
     * @return
     */
    int recursive(int[] nums, int lastelement, int index, int maxlength) {
        if (index >= nums.length) return maxlength;
        int len1 = 0;
        int len2 = 0;
        if (nums[index] > lastelement) {
            len1 = recursive(nums, nums[index], index + 1, maxlength + 1);
        }
        len2 = recursive(nums, lastelement, index + 1, maxlength);

        return Math.max(len1, len2);
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().sync(new int[]{4, 10, 4, 3, 8, 9}));
    }

    /**
     * 动态规划，是递归暴力的小优化，保存一个用当前节点为终点的子数组，且当前值是包含当前元素的最大子长度，
     * 相当于存储了所有的递归可能。
     * @param nums
     * @return
     */
    int sync(int[] nums){
        int[] lens=new int[nums.length];
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            lens[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    lens[i]=Math.max(lens[i],lens[j]+1);
                }
            }
            max=Math.max(max,lens[i]);
        }
        return max;

    }
}
