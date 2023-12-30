package com.lwf.classic.one;

public class ReplaceSpace {
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)==' '){
                    stringBuilder.append("%20");
                }else{
                    stringBuilder.append(s.charAt(i));
                }
            }
            return stringBuilder.toString();
        }
    }
}
