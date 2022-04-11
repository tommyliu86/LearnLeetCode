package com.lwf.level1.chars;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-10 18:15
 */
public class ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            int left=0;
            int right=s.length-1;
            while (left<right){
                char c = s[right];
                s[right]=s[left];
                s[left]=c;
                left++;
                right--;
            }
        }
    }
}
