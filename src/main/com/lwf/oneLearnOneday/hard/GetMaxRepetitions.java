package com.lwf.oneLearnOneday.hard;

/**
 * 466. 统计重复个数
 *
 * @author liuwenfei
 * @date 2024/1/2 9:01
 */
public class GetMaxRepetitions {
    /**
     * 阅读理解：题目：s1会重复n1次，构成一个长字符串S1，s2会重复n2次，构成S2，然后，我们需要找到S2最大的重复次数，可以从S1中找到的。
     * 分析可知道，s1和s2都是构成S1\S2的基本重复单元，那么，只要找到s2在s1的重复串中是否可以找到，以及占有多少。
     */
    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            int m = s1.length(), n = s2.length();
            int[][] d = new int[n][0];
            for (int i = 0; i < n; ++i) {
                int j = i;
                int cnt = 0;
                for (int k = 0; k < m; ++k) {
                    if (s1.charAt(k) == s2.charAt(j)) {
                        if (++j == n) {
                            j = 0;
                            ++cnt;
                        }
                    }
                }
                d[i] = new int[] {cnt, j};
            }
            int ans = 0;
            for (int j = 0; n1 > 0; --n1) {
                ans += d[j][0];
                j = d[j][1];
            }
            return ans / n2;
        }
    }


}
