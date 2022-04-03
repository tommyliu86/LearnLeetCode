package com.lwf.learn.everyday.first.day4;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-03 12:27
 */
public class ReverseWords {
    class Solution {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int left=0;
            int right=0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]==' '){
                    reverse(chars,left,right-1);
                    left=right=i+1;
                }else{
                    right++;
                }
            }
            if (left<right-1){
                reverse(chars,left,right-1);
            }
            return String.valueOf(chars);
        }
        private void reverse(char[] chars,int left,int right){
            while (left<right){
                char temp=chars[left];
                chars[left]=chars[right];
                chars[right]=temp;
                left++;
                right--;
            }
        }
    }
}
