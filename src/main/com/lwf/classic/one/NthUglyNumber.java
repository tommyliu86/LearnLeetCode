package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/2/10 11:32
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
                int a2=ints[i2]*2;
                int a3=ints[i3]*3;
                int a5=ints[i5]*5;
                ints[i]=Math.min(a2,Math.min(a3,a5));
                if (ints[i]==a2) {
                    i2++;
                }
                if (ints[i]==a3) {
                    i3++;
                }
                if (ints[i]==a5) {
                    i5++;
                }
            }
            return ints[n-1];

        }
    }
}
