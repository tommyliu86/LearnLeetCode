package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 15:12
 */
public class NthUglyNumber {
    class Solution {
        public int nthUglyNumber(int n) {
            int[] ints=new int[n];
            ints[0]=1;
            int i2=0;
            int i3=0;
            int i5=0;
            for (int i = 1; i < ints.length; i++) {
                int n2 = ints[i2] * 2;
                int n3 = ints[i3] * 3;
                int n5 = ints[i5] * 5;
                ints[i]=Math.min( Math.min(n2,n3),n5);
                if (ints[i]==n2) {
                    i2++;
                }
                if (ints[i]==n3) {
                    i3++;
                }
                if (ints[i]==n5) {
                    i5++;
                }
            }
            return ints[n-1];
        }
    }
}
