package com.lwf.level1.number;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-19 17:52
 */
public class CountPrimes {
    class Solution {

        public int countPrimes(int n) {
            boolean[] mark=new boolean[n+1];
            int count=0;
            for (int i = 2; i < n; i++) {
                if (!mark[i]){
                    for (int j = 2; j*i <n; j++) {
                        mark[i*j]=true;
                    }
                    count++;
                }
            }
            return count;
        }
    }
}
