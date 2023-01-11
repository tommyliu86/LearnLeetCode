package com.lwf.oneLearnOneday.easy;

import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/1/11 9:08
 */
public class DigitCount {
    class Solution {
        public boolean digitCount(String num) {
            int[] counts=new int[num.length()];
            for (int i = 0; i < num.length(); i++) {
               counts[num.charAt(i)-'0']++;
            }
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i)-'0'!=counts[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
