package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/6/19 9:00
 */
public class MaxSumDivThree {
    class Solution {
        public int maxSumDivThree(int[] nums) {
            //i1和i2记录除以3余1和余2的最小整数,初始化为最大值
            int i1=Integer.MAX_VALUE,i2=Integer.MAX_VALUE,sum=0;
            //遍历数组,累加和sum
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
                //odd记录当前数除以3的余数
                int odd = nums[i] % 3;
                //如果当前数除以3余1,更新i2为当前数+i1 与 i2的最小值，更新i1为当前数和i1的最小值
                if (odd==1){
                    if (nums[i] < i2-i1){
                        i2=i1+nums[i];
                    }
                    if (i1 > nums[i]) {
                        i1=nums[i];
                    }
                }
                //如果当前数除以3余2,,更新i1为 当前数+i2 与 i1的最小值，更新i2为当前数和i2的最小值
                if (odd==2){
                    if (nums[i] < i1-i2){
                        i1=i2+nums[i];
                    }
                    if (i2 > nums[i]) {
                        i2=nums[i];
                    }
                }
            }
            //sum除以3的余数
            int odd = sum % 3;
            //如果sum除以3余0,直接返回sum
            if (odd==0) {
                return sum;
                //如果sum除以3余1,返回去除最小余1整数i1后sum与0的最大值
            }else if (odd==1){
                return Math.max( sum-i1,0);
                //如果sum除以3余2,返回去除最小余2整数i2后sum与0的最大值
            }else{
                return Math.max( sum-i2,0);
            }

        }
    }
}
