package com.lwf.learn.everyday.data.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-28 15:03
 */
public class LongestPalindrome {

    class Solution {
        public int longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int[] mark=new int[128];
            int max=0;
            for (int i = 0; i < chars.length; i++) {
                mark[chars[i]]++;
                if (mark[chars[i]]==2){
                    max+=2;
                    mark[chars[i]]=0;
                }
            }

            return max<chars.length?max+1:max;
        }
    }
}
