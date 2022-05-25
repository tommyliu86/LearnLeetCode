package com.lwf.learn.everyday.arith.second.day17;

/**
 * Created with IntelliJ IDEA.
 *https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * 二维条件动态规划，
 * 一阶动态规划：dp的状态转移方程和一维数组有关，每个dp[i]和dp[i-1]~dp[0]有关，因此使用一个一维数组来存储数据即可计算
 * 二阶动态规划：dp的状态转移方程和元素i的状态有关，每个状态会构成不同的dp1[i] dp2[i]，因此使用两个或多个一维数组来保存状态
 *
 * 二维动态规划：dp的状态转移方程需要使用两个相关条件来组合，且dp[i][j]= dp[i..][j..]， dp[i..][j..]有关，这时就需要
 * 使用二维数组来存储dp，进行状态转移计算。
 *
 * @author: liuwenfei14
 * @date: 2022-04-29 10:37
 */
public class LongestCommonSubsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] y = text1.toCharArray();
            char[] x = text2.toCharArray();
            int[][] length=new int[x.length+1][y.length+1];
            for (int i = 1; i < length.length; i++) {
                for (int j = 1; j < length[i].length; j++) {
                    if (x[i-1]==y[j-1]){
                        length[i][j]=length[i-1][j-1]+1;
                    }else{
                        length[i][j]=Math.max(length[i-1][j],length[i][j-1]);
                    }
                }
            }
            return length[x.length][y.length];
        }
    }
}
