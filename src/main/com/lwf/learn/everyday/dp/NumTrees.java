package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-12 18:44
 */
public class NumTrees {
    /**
     * 题目和二叉树无关，就是一个简单的分隔排列的动态规划。
     */
    class Solution {
        public int numTrees(int n) {
            int[] sums=new int[n+1];
            sums[0]=1;
            sums[1]=1;
            for (int i = 2; i < sums.length; i++) {
                int sum=0;
                for (int j = 0; j < i; j++) {
                    sum+=sums[j]*sums[i-j-1];
                }
                sums[i]=sum;
            }
            return sums[n];
        }
    }
}
