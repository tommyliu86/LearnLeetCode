package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/submissions/
 * 172. 阶乘后的零
 *
 * @author: liuwenfei14
 * @date: 2022-03-25 09:55
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(Math.pow(5, 3));
        new Solution().trailingZeroes(3);
    }

    /**
     * 因子数计算，尾数多少个0则可以换为有多少个10，也就是2*5，由于2比5多很多，因此直接计算连续乘中有多少个5即可。
     */
    static class Solution {
        public int trailingZeroes(int n) {
            int rtn = 0;
            int pow = 1;
            int p = 0;
            while ((p = (int) Math.pow(5, pow++)) < n) {
                rtn += n / p;
            }
            return rtn;
        }
    }
}
