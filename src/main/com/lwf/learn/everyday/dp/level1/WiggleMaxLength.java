package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-19 15:43
 */
public class WiggleMaxLength {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length<2){
                return nums.length;
            }
            boolean up=true;
            int l=1;
            for (int i = 1; i < nums.length; i++) {

                if (nums[i]>nums[i-1]&&(l==1|| !up)){
                    l++;
                    up=true;
                }else if (nums[i]<nums[i-1]&&(l==1||up)){
                    l++;
                    up=false;
                }
            }
            return l;

        }
    }
}
