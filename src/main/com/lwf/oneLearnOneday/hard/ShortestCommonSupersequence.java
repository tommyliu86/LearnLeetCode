package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2023/3/28 8:58
 */
public class ShortestCommonSupersequence {
    /**
     * 最长子序列+每个字符串的字符，主要是位置的排列，因此通过动态规划找到子序列位置，再倒叙遍历来拼接出字符串即可
     */
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            int[][] dp=new int[str1.length()+1][str2.length()+1];
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    if (str1.charAt(i-1)==str2.charAt(j-1)) {
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=Math.max( dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            int i=str1.length(),j=str2.length();
            while (i>0||j>0){
                if (i==0) {
                    stringBuilder.append(str2.charAt(--j));
                }else if (j==0){
                    stringBuilder.append(str1.charAt(--i));
                }else{
                    if (str1.charAt(i-1)==str2.charAt(j-1)){
                        stringBuilder.append(str1.charAt(i-1));
                        i--;
                        j--;
                    }else if (dp[i][j]==dp[i-1][j]){
                        stringBuilder.append(str1.charAt(i-1));
                        i--;
                    }else{
                        stringBuilder.append(str2.charAt(j-1));
                        j--;
                    }
                }
            }
            return stringBuilder.reverse().toString();
        }
    }
}
