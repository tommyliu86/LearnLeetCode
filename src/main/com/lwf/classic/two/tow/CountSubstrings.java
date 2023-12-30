package com.lwf.classic.two.tow;

public class CountSubstrings {
    /**
     * 中心扩展
     */
    class Solution {

        public int countSubstrings(String s) {
            int ans=0;
            for (int i = 0; i < s.length(); i++) {
                int l=0;
                while (i-l>=0&&i+l<s.length()&&s.charAt(i-l)==s.charAt(i+l)){
                    l++;
                }
                ans+=l;

              l=0;
                while (i-1-l>=0&&i+l<s.length()&&s.charAt(i-1-l)==s.charAt(i+l)){
                   l++;
                }
                ans+=l;
            }
            return ans;
        }

    }

    /**
     * 暴力循环，
     */
    class Solution1 {
        public int countSubstrings(String s) {
            boolean[][] isPa = new boolean[s.length()][s.length()];
            for (int i = 0; i < isPa.length; i++) {
                isPa[i][i] = true;
            }
            int ans = s.length();
            for (int l = 1; l < s.length(); l++) {
                for (int i = 0; i + l < s.length(); i++) {
                    if (s.charAt(i) == s.charAt(i + l)) {
                        if (i + 1 >= i + l - 1 || isPa[i + 1][i + l - 1]) {
                            ans++;
                            isPa[i][i + l] = true;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
