package com.lwf.oneLearnOneday.hard;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-16 10:48
 */
public class LargestPalindrome {
    /**
     * 没有技巧可言。。直接暴力计算。。
     */
    class Solution {
        public int largestPalindrome(int n) {
            if (n == 1) return 9;
            int pre = (int) Math.pow(10, n) - 1;
            int min = (int) Math.pow(10, n - 1);
            for (long l = pre; l > min; l--) {
                long temp = l;
                long pa = l;
                while (temp > 0) {
                    pa = pa * 10 + temp % 10;
                    temp = temp / 10;
                }

                for (long ans = pre; ans * ans >= pa; ans--) {
                    if (pa % ans == 0) {
                        return (int) (pa % 1337);
                    }
                }
            }
            return 0;

        }
    }

    class test {
        public int largestPalindrome(int n) {
            if (n == 1) {
                return 9;
            }
            int upper = (int) Math.pow(10, n) - 1;
            int ans = 0;
            for (int left = upper; ans == 0; --left) { // 枚举回文数的左半部分
                long p = left;
                for (int x = left; x > 0; x /= 10) {
                    p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p
                }
                for (long x = upper; x * x >= p; --x) {
                    if (p % x == 0) { // x 是 p 的因子
                        ans = (int) (p % 1337);
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
