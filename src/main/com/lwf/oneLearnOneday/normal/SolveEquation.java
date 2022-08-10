package com.lwf.oneLearnOneday.normal;

public class SolveEquation {
    class Solution {
        public String solveEquation(String equation) {
            int xCount = 0;
            int rCount = 0;
            char[] chars = equation.toCharArray();
            int i = 0;
            boolean left = true;
            while (i < chars.length) {
                if (chars[i] == '=') {
                    left = false;
                    i++;

                } else {
                    int j = i + 1;
                    while (j < chars.length && chars[j] != '+' && chars[j] != '-' && chars[j] != '=') {
                        j++;
                    }
                    if (chars[j - 1] != 'x') {
                        int y = Integer.parseInt(String.valueOf(chars, i, j - i));
                        if (left) {
                            rCount -= y;
                        } else {
                            rCount += y;
                        }
                    } else {
                        int k = i;
                        int x = 0;
                        if (chars[i] == '+' || chars[i] == '-') {
                            k = i + 1;
                        }
                        if (k == j - 1) {
                            x = 1;
                        } else {
                            for (; k < j - 1; k++) {
                                x = x * 10 + (chars[k] - '0');
                            }
                        }
                        if (chars[i] == '-') {
                            x = x * -1;
                        }
                        if (left == false) {
                            x = x * -1;
                        }
                        xCount += x;
                    }

                }
            }
            if (xCount == 0) {
                if (rCount == 0) {
                    return "Infinite solutions";
                } else {
                    return "No solution";
                }
            } else {
                return "x=" + rCount / xCount;
            }
        }
    }
}
