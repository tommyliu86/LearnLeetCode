package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/9/17 22:19
 */
public class MaxLengthBetweenEqualCharacters {
    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            int[] maxes = new int[26];
            Arrays.fill(maxes, -1);
            int max = -1;
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                int aChar = chars[i] - 'a';
                if (maxes[aChar] != -1) {
                    max = Math.max(max, i - maxes[aChar] - 1);
                }else{
                    maxes[aChar]=i;
                }
            }
            return max;
        }
    }
}
