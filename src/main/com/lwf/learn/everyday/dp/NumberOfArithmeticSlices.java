package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-11 15:44
 */
public class NumberOfArithmeticSlices {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if (nums.length<3){
                return 0;
            }
            int sum =0;
            int step=nums[1]-nums[0];
            for (int i = 2; i < nums.length; ) {
                int sub=0;
                while (i<nums.length&& nums[i]-nums[i-1]==step){
                    sub++;
                    sum+=sub;
                    i++;
                }
                if (i<nums.length){

                    step=nums[i]-nums[i-1];
                    i++;
                }
            }
            return sum;
        }
    }
}
