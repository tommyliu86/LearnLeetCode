package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/1/16 17:11
 */
public class ReplaceSpaces {
    class Solution {
        public String replaceSpaces(String S, int length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                char c = S.charAt(i);
                if (c==' ') {
                    stringBuilder.append("%20");
                }else{
                    stringBuilder.append(c);
                }
            }
            return stringBuilder.toString();
        }
    }
}
