package com.lwf.learn.everyday.th75;

public class IsSubsequence {
    /**
     * 使用dp來進行計算
     */
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() > t.length()) {
                return false;
            }
            char[] charsS = s.toCharArray();
            char[] charsT = t.toCharArray();
            boolean[][] mark = new boolean[s.length() + 1][t.length() + 1];
            for (int i = 0; i < mark[0].length; i++) {
                mark[0][i] = true;

            }
            for (int i = 1; i < mark.length; i++) {
                char s1 = charsS[i - 1];
                for (int j = i; j < mark[i].length; j++) {
                    char t1 = charsT[j - 1];
                    if (s1 == t1) {
                        mark[i][j] = mark[i - 1][j - 1] || mark[i][j - 1];
                    } else {
                        mark[i][j] = mark[i][j - 1];
                    }
                }
            }
            return mark[s.length()][t.length()];

        }
    }

    class Solution1 {
        /**
         * 使用双指针，向后遍历
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isSubsequence(String s, String t) {
            if (s.length() > t.length()) {
                return false;
            }
            char[] charsS = s.toCharArray();
            char[] charsT = t.toCharArray();
            int i = 0;
            int j = 0;
            while (j < t.length() && i < s.length()) {
                char s1 = charsS[i];
                while (j < t.length() && charsT[j] != s1) {
                    j++;
                }
                if (j == t.length()) {
                    return false;
                }
                i++;
                j++;
            }
            if (i == s.length()) {
                return true;
            } else {
                return false;
            }
        }
    }

    class Solution2 {
        /**
         * 预处理的dp
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isSubsequence(String s, String t) {
            if (s.length() > t.length()) {
                return false;
            }
            char[] chars = t.toCharArray();
            int[][] index = new int[t.length() + 1][26];
            for (int i = index.length - 1; i >= 0; i--) {
                int[] index1 = index[i];
                if (i != index.length - 1) {
                    int[] index2 = index[i + 1];
                    for (int j = 0; j < index1.length; j++) {
                        index1[j] = index2[j];
                    }

                    char aChar = chars[i ];
                    index1[aChar - 'a'] = i+1;
                }


            }

            char[] chars1 = s.toCharArray();
            int i = 0;
            int j = 0;
            while (i < s.length() && j < index.length) {
                int k = chars1[i] - 'a';
                if (index[j][k] == 0) {
                    return false;
                } else {
                    j = index[j][k];
                    i++;
                }
            }
            return true;
        }
    }
}
