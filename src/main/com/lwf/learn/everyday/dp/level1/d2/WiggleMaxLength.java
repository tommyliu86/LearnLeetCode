package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-09 13:32
 */
public class WiggleMaxLength {
    class Solution {
        public int wiggleMaxLength(int[] nums) {

            int l=0;

            int status=0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i]==nums[i-1]){
                    continue;
                }
                if (nums[i]>nums[i-1]&&status<=0){
                    l++;
                    status=1;
                }
                if (nums[i]<nums[i-1]&&status>=0){
                    l++;
                    status=-1;
                }
            }
            return l+1;
        }
    }
}
