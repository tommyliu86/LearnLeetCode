package com.lwf.learn.everyday.coding.level1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-09 10:14
 */
public class FindTheDifference {
    class Solution {
        public char findTheDifference(String s, String t) {
            int[] chars=new int[26];
            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i)-'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                chars[t.charAt(i)-'a']--;
                if (chars[t.charAt(i)-'a']<0){
                    return t.charAt(i);
                }
            }
            return 'a';
        }
    }
    class test {
        public char findTheDifference(String s, String t) {
            char[] chars1 = s.toCharArray();

            char[] chars2 = t.toCharArray();

            Arrays.sort(chars1);
            Arrays.sort(chars2);
            int i1=0;
            int i2=0;
            while (i1<chars1.length&& chars1[i1]==chars2[i2]){
                i1++;
                i2++;
            }
            return chars2[i2];

        }
    }
}
