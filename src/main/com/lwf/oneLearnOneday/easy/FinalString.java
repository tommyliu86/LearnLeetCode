package com.lwf.oneLearnOneday.easy;

/**
 * 2810. 故障键盘
 * @author: liuwenfei
 * @date: 2024/4/1-8:59
 */
public class FinalString {
    class Solution {
        public String finalString(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)=='i') {
                    stringBuilder.reverse();
                }else{
                    stringBuilder.append(s.charAt(i));
                }
            }
            return stringBuilder.toString();
        }
    }
}
