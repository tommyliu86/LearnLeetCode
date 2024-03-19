package com.lwf.oneLearnOneday.easy;

/**
 * @author: liuwenfei
 * @date: 2024/3/13-9:03
 */
public class MaximumOddBinaryNumber {
    class Solution {
        /**
         * 暴力遍历
         * @param s
         * @return
         */
        public String maximumOddBinaryNumber(String s) {
            int count=0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)=='1') {
                    count++;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length()-1; i++) {
                if (count>1){
                    stringBuilder.append('1');
                    count--;
                }else{
                    stringBuilder.append('0');
                }
            }
            stringBuilder.append('1');
            return stringBuilder.toString();
        }
    }
}
