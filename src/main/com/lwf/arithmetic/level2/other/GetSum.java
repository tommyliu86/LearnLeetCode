package com.lwf.arithmetic.level2.other;

/**
 * Created with IntelliJ IDEA.
 * 位运算模拟
 * @author: liuwenfei14
 * @date: 2022-05-18 16:08
 */
public class GetSum {
    class Solution {
        public int getSum(int a, int b) {
            while (b!=0){
                int temp=a^b;
                b=(a&b)<<1;
                a=temp;
            }
            return a;
        }
    }
}
