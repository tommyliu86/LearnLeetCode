package com.lwf.learn.everyday.second.day18;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/edit-distance/submissions/
 * dp动态规划最主要的是找到状态转移的过程，从过程中推导出转移方程。因此需要注意思考的方式方法
 * @author: liuwenfei14
 * @date: 2022-04-30 10:25
 */
public class MinDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            char[] x = word1.toCharArray();
            char[] y = word2.toCharArray();
            int[][] mark=new int[x.length+1][y.length+1];
            for (int i = 0; i < mark.length; i++) {
                for (int j = 0; j < mark[i].length; j++) {
                    if (i==0||j==0){
                        mark[i][j]=i+j;
                    }else{
                        if (x[i-1]==y[j-1]){
                            mark[i][j]=Math.min( Math.min( mark[i-1][j-1],mark[i-1][j]+1),mark[i][j-1]+1);
                        }else{
                            mark[i][j]=Math.min( Math.min(mark[i-1][j],mark[i][j-1]),mark[i-1][j-1])+1;
                        }
                    }
                }
            }
            return mark[x.length][y.length];
        }
    }
}
