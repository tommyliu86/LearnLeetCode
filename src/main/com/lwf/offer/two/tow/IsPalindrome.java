package com.lwf.offer.two.tow;

/**
 * @author liuwenfei
 * @date 2023/4/7 11:17
 */
public class IsPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            int i=0,j=s.length()-1;
            while (i<j){
                while (i<j&&!check(s.charAt(i))) {
                    i++;
                }
                while (i<j&&!check(s.charAt(j))){
                    j--;
                }
                if (Character.toLowerCase( s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
        public boolean check(char c){
            if (!Character.isLetter(c)&&!(c>='0'&&c<='9')) {
                return false;
            }
            return true;
        }
    }
}
