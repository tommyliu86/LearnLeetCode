package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 11:41
 */
public class SearchInsert {
    class Solution {
        public int searchInsert(int[] nums, int target) {

            int l=0;
            int r=nums.length-1;
            while (l<r){
                int m=(l+r)/2;
                if (nums[m]==target){
                    return m;
                }else if (nums[m]>target){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }
            if (nums[l]>=target) {
                return l;
            }else{
             return l+1;
            }

        }
    }
}
