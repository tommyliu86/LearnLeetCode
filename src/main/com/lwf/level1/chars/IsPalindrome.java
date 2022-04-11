package com.lwf.level1.chars;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-11 10:56
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println('A'-0);
        System.out.println('z'-0);
        System.out.println('9'-0);
        System.out.println('_'-0);
        char a='a';
        if (a>'Z'){
            a-=32;
        }
        System.out.println(a);
        boolean aChar = new Solution().isChar('_');
        System.out.println(aChar);
        new Solution().isPalindrome("ab_a");
    }
  static   class Solution {
        public boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();
            int left=0;
            int right=chars.length-1;
            while (left<right){
                if (!isChar(chars[left])){
                    left++;
                }else if (!isChar(chars[right])){
                    right--;
                }else{
                    if (charEqual(chars[left],chars[right])){
                        left++;
                        right--;
                    }else{
                        return false;
                    }
                }
            }
            return true;
        }
        private boolean isChar(char a){
            return (a>='A'&&a<='Z')||(a>='a'&&a<='z')||(a>='0'&&a<='9');
        }
        private  boolean charEqual(char a,char b){
            if (a>'Z') {
                a-=32;
            }
            if (b>'Z'){
                b-=32;
            }
            return a==b;
        }
    }
}
