package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 09:58
 */
public class IsMonotonic {
    class Solution {
        public boolean isMonotonic(int[] nums) {
            int up=0;
            int down=0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i]>nums[i-1]){
                    up++;
                }else if (nums[i]<nums[i-1]){
                    down++;
                }
                if (up>1&&down>1){
                    return false;
                }
            }
            return true;
        }
    }
}
