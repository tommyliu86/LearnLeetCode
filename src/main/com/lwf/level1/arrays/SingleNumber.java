package com.lwf.level1.arrays;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-09 12:52
 */
public class SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            int rtn=0;
            for(int i=0;i<nums.length;i++){
                rtn^=nums[i];
            }
            return rtn;
        }
    }
    class method2 {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i+=2) {
                if (i+1==nums.length|| nums[i]!=nums[i+1]){
                    return nums[i];
                }
            }
            return -1;
        }
    }
}
