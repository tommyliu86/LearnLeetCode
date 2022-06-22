package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-13 19:11
 */
public class Search {
    class Solution {
        public int search(int[] nums, int target) {
            if (nums[0]>target||nums[nums.length-1]<target){
                return -1;
            }
            int i = half(nums, 0, nums.length - 1, target);
            if (nums[i]==target){
                return i;
            }else{
                return -1;
            }
        }
        public int half(int[] nums,int l,int r,int t){
            if (l>=r){
                return l;
            }
            int m=(l+r)/2;
            if (nums[m]==t){
                return m;
            }else if (nums[m]<t){
                return half(nums,m+1,r,t);
            }else{
                return half(nums,l,m-1,t);
            }
        }
    }
}
