package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/10/14 17:31
 */
public class NumDistinct {
    public static void main(String[] args) {
        new Solution().numDistinct(
                "babgbag",
                "bag");
    }
 static    class Solution {
        public int numDistinct(String s, String t) {
            char[] chars = s.toCharArray();
            char[] chart = t.toCharArray();
            int[][] marks=new int[chart.length+1][chars.length+1];
            Arrays.fill(marks[0],1);
            for (int i = 1; i < marks.length; i++) {
                int sum=0;
                char tchar=chart[i-1];
                for (int j = 1; j < marks[i].length; j++) {
                    if (chars[j-1]==tchar){
                        sum+=marks[i-1][j-1];
                    }
                    marks[i][j]=sum;
                }
            }
            return marks[chart.length][chars.length];
        }
    }
}
