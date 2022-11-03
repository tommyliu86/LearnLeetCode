package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/11/3 8:40
 */
public class MaxRepeating {
    /**
     * 动态规划，使用 末尾i值判断是否匹配到一个word，然后记录连续匹配 到的长度
     */
    class Solution {
        public int maxRepeating(String sequence, String word) {
            if (sequence.length() < word.length()) {
                return 0;
            }
            char[] chars = sequence.toCharArray();
            char[] sub = word.toCharArray();
            int[] ks = new int[sequence.length()];
            int n = word.length();
            int max = 0;
            for (int i = n - 1; i < sequence.length(); i++) {
                if (eq(chars, i, sub)) {
                    ks[i] = 1 + (i - n >= 0 ? ks[i - n] : 0);
                    max = Math.max(max, ks[i]);
                }
            }
            return max;
        }

        public boolean eq(char[] chars, int r, char[] sub) {
            int gap = r - sub.length + 1;
            for (int i = r; i >= gap; i--) {
                if (chars[i] != sub[i - gap]) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 有意识的锻炼快速写题
     */
    class Solution1 {
        public int maxRepeating(String sequence, String word) {

            int k = 0;
            String s = word;
            while (sequence.contains(s)) {
                s += word;
                k++;
            }
            return k;
        }
    }
}
