package com.lwf.arithmetic.level2.number;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 18:39
 */
public class Divide {
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) {
                return 0;
            }
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            int n = 0;

            int i1 = dividend > 0 ? 1 : -1;
            int i2 = divisor > 0 ? 1 : -1;
            dividend = dividend > 0 ? -1 * dividend : dividend;
            divisor = divisor > 0 ? -1 * divisor : divisor;

            while (dividend <= divisor) {

                int cur = divisor;
                int i = 1;
                while (cur > dividend - cur) {
                    cur += cur;
                    i += i;
                }
                dividend -= cur;
                n += i;
            }
            return i1 * i2 * n;
        }
    }

    class test {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) {
                return 0;
            }
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            int n = 0;

            int i1 = dividend > 0 ? 1 : -1;
            int i2 = divisor > 0 ? 1 : -1;
            dividend = dividend > 0 ? -1 * dividend : dividend;
            divisor = divisor > 0 ? -1 * divisor : divisor;
            return i1*i2*div(dividend,divisor);
        }
        private int div(int div,int d){
            int n=0;
            if (div <= d) {
                int cur = d;
                int i = 1;
                while (cur > div - cur) {
                    cur += cur;
                    i += i;
                }
                div -= cur;
                n += i;
            }
            if (div<=d){
                n+=div(div,d);
            }
            return n;
        }
    }
}
