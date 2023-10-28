package com.lwf.offer;

/**
 * 二分查找
 * CR 068. 搜索插入位置
 * https://leetcode.cn/problems/N6YdxV/description/?envType=study-plan-v2&envId=coding-interviews-special
 */
public class SearchInsert {
    /**
     * 存在相等情况，则使用三个判断，，不存在找位置，则多一个相等判断即可。
     */
    class Solution {
        public int searchInsert(int[] nums, int target) {

            int i=0,j=nums.length-1;
            while (i<=j){
                int m=i+(j-i)/2;
                if (nums[m]==target){
                    return m;
                }else if (nums[m]>target){
                    j=m-1;
                }else{
                    i=m+1;
                }
            }
            return i;
        }

    }
}
