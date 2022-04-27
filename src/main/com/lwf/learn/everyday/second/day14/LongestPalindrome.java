package com.lwf.learn.everyday.second.day14;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-26 09:30
 */
public class LongestPalindrome {

    class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();

            int max = 1;
            int left = 0;
            int right = 0;
            for (int i = 0; i + max < chars.length; i++) {
                for (int j = chars.length-1; j > i; j--) {
                    if (j-i+1>max&&isPa(chars,i,j)){
                        max=j-i+1;
                        left=i;
                        right=j;
                        break;
                    }
                }
            }
            return s.substring(left, right + 1);
        }

        public boolean isPa(char[] chars, int left, int right) {
            while (left < right && chars[left] == chars[right]) {
                left++;
                right--;
            }
            return left >= right;
        }
    }
}
