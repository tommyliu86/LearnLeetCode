package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/2/27 10:04
 */
public class MovesToMakeZigzag {
    /**
     * 迭代遍历，理解题目重点，需要找到偶元素小于两边，或者奇元素小于两边的最小值，因此我们每次找到左右两边的最小值min，改变i小于min，由于偶元素和奇元素
     * 的变化不影响当前的计算，因此不需要额外记录任何变化。
     */
    class Solution {
        public int movesToMakeZigzag(int[] nums) {
            int o=0,a=0;
            for (int i = 0; i < nums.length; i++) {
                int pre=i-1<0?Integer.MAX_VALUE:nums[i-1];
                int post=i+1==nums.length?Integer.MAX_VALUE: nums[i+1];
                int min = Math.min(pre, post) ;
                if (min<=nums[i]) {
                    if (i%2==0) {
                        //o 小于两边
                        o+= nums[i]-min+1;

                    }else{
                        a+= nums[i]-min+1;
                    }
                }

            }
            return Math.min(o,a);
        }
    }
}
