package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 14:23
 */
public class NumberOfArithmeticSlices {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if (nums.length<3){
                return 0;
            }
            int sum=0;
            int step=nums[1]-nums[0];
            for (int i = 2; i < nums.length; i++) {
                int sub=0;
                while (i<nums.length&& nums[i]-nums[i-1]==step) {
                    sub=sub+1;
                    i++;
                    sum+=sub;
                }
                if (i<nums.length){
                    step=nums[i]-nums[i-1];
                }

            }
            return sum;
        }
    }
}
