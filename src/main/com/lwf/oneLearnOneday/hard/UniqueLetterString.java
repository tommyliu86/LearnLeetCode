package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

public class UniqueLetterString {
    /**
     * 只需要考虑字符串本身的重复出现的头和尾就行！
     */
    class Solution {
        public int uniqueLetterString(String s) {
            int[][] lengths=new int[s.length()][2];
            int[] indexes=new int[26];
            Arrays.fill(indexes,-1);
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                int aChar = chars[i]-'A';

                lengths[i][0]=indexes[aChar];
                indexes[aChar]=i;

            }
            int right=s.length();
            Arrays.fill(indexes,right);
            for (int i = chars.length-1; i >= 0; i--) {
                int aChar = chars[i]-'A';

                lengths[i][1]=indexes[aChar];
                indexes[aChar]=i;
            }
            int rtn=0;
            for (int i = 0; i < lengths.length; i++) {
                rtn+=(i- lengths[i][0])*(lengths[i][1]-i);
            }
            return rtn;
        }
    }
}
