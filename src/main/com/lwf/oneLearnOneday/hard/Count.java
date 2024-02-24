package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * 2719. 统计整数数目
 * @author liuwenfei
 * @date 2024/1/16 8:30
 */
public class Count {
    /**
     * 数位dp
     *
     * https://leetcode.cn/problems/count-of-integers/solutions/2296043/shu-wei-dp-tong-yong-mo-ban-pythonjavacg-9tuc/?envType=daily-question&envId=2024-01-11
     */
    class Solution {
        /**
         * 题目中要求的min和max是数位和，因此我们需要记录当前的和，然后再进行指定长度上的求解
         * @param num1
         * @param num2
         * @param min_sum
         * @param max_sum
         * @return
         */
        public int count(String num1, String num2, int min_sum, int max_sum) {
            int count1 = count(num1, min_sum, max_sum);
            int count2=count(num2,min_sum,max_sum);
            //补充计算num1是否是符合要求的，因为count2中包含了num1，直接减去就会变少了
            int sum=0;
            for (int i = 0; i < num1.length(); i++) {
                sum+=num1.charAt(i)-'0';
            }
            return (count2-count1+mod)%mod +(sum>=min_sum&&sum<=max_sum?1:0);

        }
        private int  mod=1000_000_007;
        public int count(String num,int min ,int max){
            //使用二维数组进行dp数据记录
            int l = num.length();
            //数组的第二维使用的是当前前缀和，记录每一位上如果前缀和是j，当前的count
            int[][] dp=new int[l][Math.min(l*9,max)+1];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill( dp[i],-1);
            }
            return dfs(0,0,true,num,min,max,dp);

        }
        //数位dp就是按照每一位上的数字取值，进行dp计算。。使用记忆化搜索
        public int dfs(int i,int presum,boolean isLimit,String num,int min,int max,int[][] dp){
            if (presum>max){
                return 0;
            }
            if (i==num.length())
                return presum>=min?1:0;

            if (!isLimit&&dp[i][presum]!=-1)
                return dp[i][presum];

            int up=isLimit?(num.charAt(i)-'0'):9;
            int curCount=0;
            for (int j = 0; j <= up; j++) {
                curCount=(curCount+dfs(i+1,presum+j,isLimit&&(j==up),num,min,max,dp))%mod;
            }
            if (!isLimit)
                dp[i][presum]=curCount;

            return curCount;
        }

    }
}
