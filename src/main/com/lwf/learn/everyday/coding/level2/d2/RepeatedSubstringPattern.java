package com.lwf.learn.everyday.coding.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 17:16
 */
public class RepeatedSubstringPattern {
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();
            if (n%2==1){
                return false;
            }
            char[] chars = s.toCharArray();
            int l=1;
            while (l<n/2){
                int i=l;

                while (i<n&& chars[i]==chars[i%l]){
                    i++;
                }
                if (i==n&& n%l==0){
                    return true;
                }
                l++;
            }
            return false;
        }
    }
}
