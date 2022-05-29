package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-26 15:08
 */
public class Jump {
    class Solution {
        public int jump(int[] nums) {
            int left=0;
            int right=0;
            int step=0;
            while (right<nums.length-1){
                int max=right;
                for (int i = left; i <= right; i++) {
                    max=Math.max(nums[i],max);
                }
                if (max<=right){
                    break;
                }else{
                    left=right+1;
                    right=max;
                }
                step++;
            }
            return step;
        }
    }
}
