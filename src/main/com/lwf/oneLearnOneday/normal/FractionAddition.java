package com.lwf.oneLearnOneday.normal;

public class FractionAddition {
    class Solution {
        public String fractionAddition(String expression) {
            int x1 = 0;
            int y1 = 0;
            char[] chars = expression.toCharArray();
            int i = 0;
            while (i < chars.length) {
                int x2, y2;
                int j = i;
                while (j < chars.length && chars[j] != '/') {
                    j++;
                }
                x2 = Integer.parseInt(String.valueOf(chars, i, j - i));
                i = j + 1;
                while (j < chars.length && chars[j] != '+' && chars[j] != '-') {
                    j++;
                }
                y2 = Integer.parseInt(String.valueOf(chars, i, j - i));

                if (x1 == 0 && y1 == 0) {
                    x1 = x2;
                    y1 = y2;
                } else {
                    x1 *= y2;
                    x2 *= y1;
                    x1 += x2;
                    y1 *= y2;
                    int gcd = Math.abs(gcd(x1, y1));
                    x1 /= gcd;
                    y1 /= gcd;
                }

                i = j;
            }
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append(x1).append("/").append(y1).toString();
        }

        public int gcd(int x, int y) {
            return x != 0 ? gcd(y % x, x) : y;
        }
    }
}
