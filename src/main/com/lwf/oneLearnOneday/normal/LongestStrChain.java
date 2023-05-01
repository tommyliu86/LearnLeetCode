package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuwenfei
 * @date 2023/4/27 9:12
 */
public class LongestStrChain {
    /**
     * dp，保存每个节点为end的最大长度， 双指针，比较两个字符串是否符合即可。
     */
    class Solution {
        public int longestStrChain(String[] words) {
            if (words.length == 1) return 1;
            int[] dp = new int[words.length];
            Arrays.fill(dp, 1);
            Arrays.sort(words, Comparator.comparing(String::length));

            int i = 0;
            int max = 1;
            while (i < words.length) {
                int j = i - 1;
                while (j >= 0) {
                    if (words[i].length() - words[j].length() > 1) {
                        break;
                    }
                    if (isSim(words[i], words[j])) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                    j--;
                }
                max = Math.max(max, dp[i]);
                i++;
            }
            return max;

        }

        public boolean isSim(String a, String b) {
            if (a.length() - b.length() == 1) {
                int i = 0, j = 0;
                boolean removed = false;
                while (i < a.length() && j < b.length()) {
                    if (a.charAt(i) != b.charAt(j)) {
                        if (removed) {
                            return false;
                        } else {
                            removed = true;
                            i++;
                        }
                    }else{
                        i++;
                        j++;
                    }
                }
                return removed ? (i - j==1) : (i == j );
            }
            return false;
        }
    }
}
