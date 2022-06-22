package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 09:59
 */
public class SmallestDistancePair {
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int l=0;
            int r=nums[nums.length-1]-nums[0];
            //最小，最大距离的值，按照这个值进行二分，
            while (l<r){
                int m=(l+r)/2;
                int count = countNum(nums, m);
                if (count>=k){ //大于等于k时，考虑同一个距离下会有多个值，因此是有可能是这个距离的，因此r=m
                    r=m;
                }else{
                    l=m+1;
                }
            }
            return l;
        }
        //滑动窗口统计小于等于m的数对个数
        public int countNum(int[] nums,int m){
            int l=0;
            int r=1;
            int count=0;
            while (r<nums.length){
               while (nums[r]-nums[l]>m){
                   l++;
               }
               count+=r-l;
               r++;
            }
            return count;
        }
    }
}
