package com.lwf.classic.two;

/**
 * LCR 072. x 的平方根
 * @author liuwenfei
 * @date 2023/11/10 16:05
 */
public class MySqrt {
    /**
     * 二分查找
     */
    class Solution {
        public int mySqrt(int x) {
            int i = 0, j = x;
            while (i <= j) {
                int m = i + (j - i) / 2;
                if (m * m > x) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
            return j;
        }
    }

}
