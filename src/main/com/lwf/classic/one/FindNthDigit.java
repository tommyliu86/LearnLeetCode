package com.lwf.classic.one;

public class FindNthDigit {
    class Solution {
        public int findNthDigit(int n) {
            int d = 1, count = 9;
            //按照位数计算当前位数的数字组成的长度，
            while (n > (long) d * count) {
                n -= d * count;
                d++;
                count *= 10;
            }
            //当前的d就是所在的位数，n表示当前位数的第几个

            //找到对应的位数数字大小，计算是哪一位的数字，然后返回
            int index = n - 1;
            int start = (int) Math.pow(10, d - 1);
            int num = start + index / d;
            int digitIndex = index % d;
            int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
            return digit;
        }
    }

}
