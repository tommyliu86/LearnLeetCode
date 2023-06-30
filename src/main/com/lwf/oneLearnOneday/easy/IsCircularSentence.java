package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/6/30 8:37
 */
public class IsCircularSentence {
    class Solution {
        public boolean isCircularSentence(String sentence) {
            if (sentence.charAt(0)!=sentence.charAt(sentence.length()-1))return false;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i)==' '){
                    if (sentence.charAt(i-1)!=sentence.charAt(i+1))return false;
                }
            }
            return true;
        }
    }
}
