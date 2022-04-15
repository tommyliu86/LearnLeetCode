package com.lwf.learn.everyday.second.day2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-15 16:28
 */
public class FindPeakElement {
    /**
     * 二分查找的变化，注意这里要理解题目，由于数组的两边=负无穷，因此，可以只考虑单边情况。
     * 只比较 i和i+1的大小，由于mid 计算是向下取整，因此i+1肯定不会越界，i<i+1，则查找右边区间，反之查找左边区间
     */
    class half {
        public int findPeakElement(int[] nums) {
            return half(nums,0,nums.length-1);

        }
        int half(int[] nums,int left,int right){
            if (left>=right){
                return left;
            }
            int mid=(left+right)/2;

             if(nums[mid]>nums[mid+1]){
                return half(nums,left,mid);
            }else{
                return half(nums,mid+1,right);
            }
        }
    }
    // 最大值肯定符合要求。
    class Solution {
        public int findPeakElement(int[] nums) {
                int max=Integer.MIN_VALUE;
                int index=-1;
            for (int i = 0; i < nums.length; i++) {
                index=max>nums[i]?index:i;
                max=Math.max(max,nums[i]);
            }
            return index;
        }
    }


}
