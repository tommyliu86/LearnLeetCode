package com.lwf.learn.everyday.arith.second.day4;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-16 17:55
 */
public class MaxArea {
    class Solution {
        public int maxArea(int[] height) {
            int left=0;
            int right=height.length-1;
            int max=0;
            while (left<right){
                max=Math.max (max,(right-left)*(Math.min(height[left],height[right])));
                if (height[left]>height[right]){
                    right--;
                }else{
                    left++;
                }
            }
            return max;
        }
    }
}
