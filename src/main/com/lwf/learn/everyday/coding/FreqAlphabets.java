package com.lwf.learn.everyday.coding;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-10 11:43
 */
public class FreqAlphabets {
    class Solution {
        public String freqAlphabets(String s) {
            char[] chars = s.toCharArray();
            StringBuilder builder = new StringBuilder();

            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i]=='#'){
                    int index=0;
                    for (int j = 0; j < 2; j++) {
                        i--;
                        index+= (chars[i]-'0')*Math.pow(10,j);
                    }
                    builder.append((char)('a'+ index-1));
                }else{
                   builder.append((char) ('a'+  chars[i]-'0'-1));
                }
            }
            return builder.reverse().toString();
        }
    }
}
