package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/7/17 9:42
 */
public class AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {
            int step = 0, i1 = num1.length() - 1, i2 = num2.length() - 1;
            StringBuilder stringBuilder = new StringBuilder();

            while (i1 >= 0 || i2 >= 0 || step > 0) {
                int j1 = i1 >= 0 ? num1.charAt(i1--) - '0' : 0;
                int j2 = i2 >= 0 ? num2.charAt(i2--) - '0' : 0;
                int cur = step + j1 + j2;
                step = cur / 10;
                stringBuilder.append(cur % 10);

            }
            return stringBuilder.reverse().toString();
        }
    }
}
