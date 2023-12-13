package com.lwf.oneLearnOneday.easy;

/**
 * 2697. 字典序最小回文串
 * @author liuwenfei
 * @date 2023/12/13 8:38
 */
public class MakeSmallestPalindrome {
    class Solution {
        public String makeSmallestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int i=0,j=chars.length-1;
            while (i<j){
                if (chars[i]!=chars[j]) {

                        chars[i]=chars[i]> chars[j]?chars[j]:chars[i];
                        chars[j]=chars[i];

                }
                i++;
                j--;
            }
            return String.valueOf(chars);
        }
    }
}
