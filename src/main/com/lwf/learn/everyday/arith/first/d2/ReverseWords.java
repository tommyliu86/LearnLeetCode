package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 15:17
 */
public class ReverseWords {
    class Solution {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            StringBuilder builder = new StringBuilder();

            int l=0;
            int r=0;
            while (r<chars.length){
                while (r<chars.length&&chars[r]!=' '){
                    r++;
                }
                for (int i = r-1; i >=l; i--) {
                    builder.append(chars[i]);
                }
                if (r!=chars.length){
                    builder.append(chars[r]);
                }
                l=++r;
            }
            return builder.toString();
        }
    }
}
