package com.lwf.learn.everyday.coding.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-19 18:02
 */
public class LengthOfLastWord {
    class Solution {
        public int lengthOfLastWord(String s) {
            char[] chars = s.toCharArray();
            int max = 0;
            int i = chars.length - 1;

            while (max == 0 && chars[i] == ' ') {
                i--;
            }
            while (i >= 0 && chars[i] != ' ') {
                max++;
                i--;
            }
            return max;
        }
    }
}
