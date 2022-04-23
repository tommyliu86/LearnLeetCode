package com.lwf.arithmetic.level1.chars;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-11 10:39
 */
public class IsAnagram {
    /**
     * 排序后比较
     */
    class test {
        public boolean isAnagram(String s, String t) {
            if (s.length()!=t.length()) {
                return false;
            }
            char[] schars = s.toCharArray();
            char[] tchars = t.toCharArray();
            int[] charCount=new int[128];

            for (int i = 0; i < schars.length; i++) {

                charCount[schars[i]]++;
            }
            for (int i = 0;i < tchars.length; i++) {
                charCount[tchars[i]]--;
                if (charCount[tchars[i]]<0){
                    return false;
                }
            }
            return true;
        }
    }
    /**
     * 排序后比较
     */
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length()!=t.length()) {
                return false;
            }
            char[] schars = s.toCharArray();
            char[] tchars = t.toCharArray();
            Arrays.sort(schars);
            Arrays.sort(tchars);
            for (int i = 0; i < schars.length; i++) {
                if (schars[i]!=tchars[i]){
                    return false;
                }
            }
            return true;

        }
    }
}
