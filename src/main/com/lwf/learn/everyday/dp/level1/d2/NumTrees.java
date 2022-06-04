package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 15:27
 */
public class NumTrees {
    class Solution {
        public int numTrees(int n) {
            int[] count=new int[n+1];
            count[0]=1;
            count[1]=1;
            for (int i = 2; i < count.length; i++) {
                int c=0;
                for (int j = 0; j < i; j++) {
                    c+=(count[j]*count[i-j-1]);
                }
                count[i]=c;
            }
            return count[n];
        }
    }
}
