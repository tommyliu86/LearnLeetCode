package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-30 10:54
 */
public class NumPrimeArrangements {
    class Solution {
        public int numPrimeArrangements(int n) {
            boolean[] is=new boolean[n];
            int count=0;
            for (int i = 1; i < n; i++) {
                if (!is[i]){
                    count++;
                    int j=i+1;
                    for (int k = 2; k*j <= n; k++) {
                        is[k*j-1]=true;
                    }
                }
            }
            long m=1;
            for (int i = 1; i <= count; i++) {
                m*=i;
            }
            long mm=1;
            for (int i = 1; i <= n-count; i++) {
                mm*=i;
            }
            return (int)( m*mm %1000000007);
        }
    }
}
