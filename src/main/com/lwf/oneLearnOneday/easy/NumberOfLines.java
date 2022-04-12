package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-12 09:29
 */
public class NumberOfLines {
    class Solution {
        public int[] numberOfLines(int[] widths, String s) {
            int sum=0;
            char[] chars = s.toCharArray();
            int lines=1;
            for (int i = 0; i < chars.length; i++) {
                int width = widths[chars[i]-'a'];
                if (sum+width>100){
                    sum=0;
                    lines++;
                }
                sum+=width;
            }
            return new int[]{lines,sum};
        }
    }
}
