package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

public class MaxProduct {
    class Solution {
        public int maxProduct(int[] nums) {
            Arrays.sort(nums);

                return (nums[nums.length-1]-1 )*(nums[nums.length-2]-1);


        }
    }

    /**
     * 常数变量保存两个最大值，直接一次遍历
     */
    class Solution1 {
        public int maxProduct(int[] nums) {
            int f=0;
            int s=0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num>f){
                    s=f;
                    f=num;
                }else if (num>s){
                    s=num;
                }
            }
            return (f-1)*(s-1);
        }
    }
}
