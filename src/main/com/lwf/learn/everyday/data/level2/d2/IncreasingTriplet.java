package com.lwf.learn.everyday.data.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 17:22
 */
public class IncreasingTriplet {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums.length<3){
                return  false;
            }
            int pre=nums[0];
            int cur=pre;
            int i=1;
            while (i<nums.length){
                if (nums[i]>=pre){
                    pre=nums[i];
                }else{
                    cur=nums[i];
                    break;
                }
            }
            while (i<nums.length){
                if (nums[i]>cur){
                    return true;
                }else if (nums[i]<=pre){
                    pre=nums[i];
                }else{
                    cur=nums[i];
                }
            }
            return false;
        }
    }
}
