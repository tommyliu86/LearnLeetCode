package com.lwf.learn.everyday.first.day4;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-03 12:23
 */
public class ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            int left=0;
            int right=s.length-1;
            while (left<right){
                char temp=s[left];
                s[left]=s[right];
                s[right]=temp;
                left++;
                right--;
            }
        }
    }
}
