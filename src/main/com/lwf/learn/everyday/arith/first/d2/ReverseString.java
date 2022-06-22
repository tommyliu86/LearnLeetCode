package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 15:15
 */
public class ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            int l=0;
            int r=s.length-1;
            while (l<r){
                char temp=s[r];
                s[r]=s[l];
                s[l]=temp;
                l++;
                r--;
            }
        }
    }
}
