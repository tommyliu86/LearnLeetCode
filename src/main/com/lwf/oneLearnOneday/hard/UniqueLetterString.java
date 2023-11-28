package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * 828. 统计子串中的唯一字符
 */
public class UniqueLetterString {
    /**
     * 计数，每个字母cur，只要统计其左边的重复位置和右边的重复位置，然后使用左边*右边就可以知道其字母贡献值
     * 遍历，左右长度记录之后，进行计算即可
     */
    class Solution {
        public int uniqueLetterString(String s) {
            int[] indexes = new int[26];
            int[] lefts = new int[26];
            Arrays.fill(indexes, -1);
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                int cur = s.charAt(i) - 'A';
                int l = i - indexes[cur];
                ans += lefts[cur] * l;
                lefts[cur] = l;
                indexes[cur] = i;
            }
            for (int i = 0; i < indexes.length; i++) {
                ans += lefts[i] * (s.length() - indexes[i]);
            }
            return ans;
        }

    }

    /**
     * 只需要考虑字符串本身的重复出现的头和尾就行！
     */
    class Solution1 {
        public int uniqueLetterString(String s) {
            int[][] lengths = new int[s.length()][2];
            int[] indexes = new int[26];
            Arrays.fill(indexes, -1);
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                int aChar = chars[i] - 'A';

                lengths[i][0] = indexes[aChar];
                indexes[aChar] = i;

            }
            int right = s.length();
            Arrays.fill(indexes, right);
            for (int i = chars.length - 1; i >= 0; i--) {
                int aChar = chars[i] - 'A';

                lengths[i][1] = indexes[aChar];
                indexes[aChar] = i;
            }
            int rtn = 0;
            for (int i = 0; i < lengths.length; i++) {
                rtn += (i - lengths[i][0]) * (lengths[i][1] - i);
            }
            return rtn;
        }
    }
}
