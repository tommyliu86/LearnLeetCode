package com.lwf.learn.everyday.second.day18;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-30 14:49
 */
public class IntegerBreak {
    class Solution {
        public int integerBreak(int n) {
            int [] sums=new int[n+1];
            sums[0]=0;
            sums[1]=0;
            for (int i = 2; i < sums.length; i++) {
                int num=0;
                for (int j = 1; j < i; j++) {
                    num=Math.max( Math.max(j,sums[j])*Math.max(i-j, sums[i-j]),num);
                }
                sums[i]=num;
            }
            return sums[n];
        }
    }
}
