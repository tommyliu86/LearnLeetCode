package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/3/3 20:21
 */
public class CountSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            int[][] count=new int[s.length()][s.length()];
            for (int i = 0; i < count.length; i++) {
                count[i][i]=1;
            }
            for (int i = 1; i < s.length() - 1; i++) {
                for (int j = 0; j+i < s.length(); j++) {
                    count[j][j+i]=Math.max(1+count[j+1][j+i],1+count[j][j+i]) s.charAt(j)==s.charAt(j+i)?
                }
            }
        }
    }
}
