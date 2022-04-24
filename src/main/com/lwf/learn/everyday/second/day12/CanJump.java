package com.lwf.learn.everyday.second.day12;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-24 09:38
 */
public class CanJump {
    class Solution {
        public boolean canJump(int[] nums) {
            int maxIndex=nums[0];
            int i=0;
            while (i<nums.length&&maxIndex>=i){
                if (nums[i]+i>maxIndex){
                    maxIndex=nums[i]+i;
                }

                i++;
            }
            return maxIndex>=nums.length-1;
        }

        /**
         * 倒退法，如果要到达最后n的位置，则n-1至少要1才行，如果n-1不够，则需要n-2>1+1，因此从后向前，可以找到开始位置0需要的最少步数
         * @param nums
         * @return
         */
        public boolean canJump2(int[] nums) {
           int min=1;
            for (int i = nums.length - 2; i >0; i--) {
                if (nums[i]<min){
                    min++;
                }else{
                    min=1;
                }
            }
            return nums[0]>=min;
        }
    }
}
