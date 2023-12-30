package com.lwf.classic.one;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/1/16 14:14
 */
public class MissingNumber {
    /**
     * 二分查找
     */
    class Solution {
        public int missingNumber(int[] nums) {
            int l=0,r=nums.length-1;
            while (l<=r){
                int mid=(l+r)/2;
                if (nums[mid]==mid){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
            return r+1;
        }
    }
    /**
     * 数学计算
     */
    class Solution1 {
        public int missingNumber(int[] nums) {
            int sum= Arrays.stream(nums).sum();
            int trueSum=(0+nums.length-1)*nums.length/2;
            return nums.length- (sum-trueSum);
        }
    }
}
