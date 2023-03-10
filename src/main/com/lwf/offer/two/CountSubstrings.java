package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/3/3 20:21
 */
public class CountSubstrings {
    /**
     * 中心回文串计数
     */
    class Solution {
        public int countSubstrings(String s) {
            int c=0;
            for (int i = 0; i < s.length(); i++) {

                int l=0;
                while (i-l>=0&&i+l<s.length()&&s.charAt(i-l)==s.charAt(i+l)){
                    l++;
                }
                c+=l;
                if (i+1<s.length()&& s.charAt(i)==s.charAt(i+1)){
                    l=0;
                    while (i-l>=0&&i+1+l<s.length()&&s.charAt(i-l)==s.charAt(i+1+l)){
                        l++;
                    }
                    c+=l;
                }
            }
            return c;
        }
    }

    /**
     * 标记法，遍历
     */
    class Solution1 {
        public int countSubstrings(String s) {
            int[][] count = new int[s.length()][s.length()];
            for (int i = 0; i < count.length; i++) {
                count[i][i] = 1;
            }
            int c = s.length();
            for (int l = 1; l < s.length(); l++) {
                for (int i = 0; i + l < s.length(); i++) {

                    if (s.charAt(i) == s.charAt(i + l)) {
                        count[i][i + l] = i + 1 <= i + l - 1 ? count[i + 1][i + l - 1] : 1;
                    }
                    c += count[i][i + l];
                }
            }
            return c;
        }
    }
}
