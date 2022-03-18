package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/sum-of-subarray-ranges/
 * 2104. 子数组范围和
 * @author: liuwenfei14
 * @date: 2022-03-04 09:51
 */
public class SubArrayRanges {
    public static void main(String[] args) {
    }
    public class SubArrayRanges1 {
        /**
         * 栈。没思路~~
         *
         * @param nums
         * @return
         */
        public long subArrayRanges(int[] nums) {
            int left=0;
            long num=0;
            while (left<nums.length-1){
                int min=nums[left];
                int max=nums[left];

                for (int i = left; i < nums.length; i++) {
                    min=Math.min(min,nums[i]);
                    max=Math.max(max,nums[i]);
                    num+=Math.abs( max-min);
                }
                left++;
            }
            return num;
        }
    }
    /**
     * 迭代循环，定义left指针，作为子数组起点，终点是left+1~length-1，因此直接遍历循环，使用两个变量保存当前的最大最小值，并进行计算
     * O(n*n)
     * @param nums
     * @return
     */
    public long subArrayRanges(int[] nums) {
       int left=0;
       long num=0;
        while (left<nums.length-1){
            int min=nums[left];
            int max=nums[left];

           for (int i = left; i < nums.length; i++) {
               min=Math.min(min,nums[i]);
               max=Math.max(max,nums[i]);
               num+=Math.abs( max-min);
           }
           left++;
       }
        return num;
    }
}
