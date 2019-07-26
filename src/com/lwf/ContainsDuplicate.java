package com.lwf;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(1 ^2^4^1);
    }

    /**
     * 思路。是否有重复元素，通过排序后比较相邻两个数是否相等就可以了
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if ((nums[i]^nums[i+1])==0) return true;
        }
        return false;
    }

    /**
     * 遍历，使用set保存元素，进行比较
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            else {
                set.add(num);
            }
        }
        return false;
    }
}
