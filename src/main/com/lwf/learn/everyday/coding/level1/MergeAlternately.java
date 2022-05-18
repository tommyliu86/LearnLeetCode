package com.lwf.learn.everyday.coding.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-09 10:02
 */
public class MergeAlternately {
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            int i1=0;
            int i2=0;
            StringBuilder builder = new StringBuilder();
            while (i1<word1.length()&&i2<word2.length()){
                builder.append(word1.charAt(i1++));
                builder.append(word2.charAt(i2++));
            }
            if (i1<word1.length()){
                builder.append(word1.substring(i1,word1.length()));
            }
            if (i2<word2.length()){
                builder.append(word2.substring(i2,word2.length()));
            }
            return builder.toString();
        }
    }
}
