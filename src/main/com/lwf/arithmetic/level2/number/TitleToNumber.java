package com.lwf.arithmetic.level2.number;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 17:04
 */
public class TitleToNumber {
    class Solution {
        public int titleToNumber(String columnTitle) {
            int r=0;
            char[] chars = columnTitle.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                r=r*26+(chars[i]-'A'+1);
            }
            return r;
        }
    }
}
