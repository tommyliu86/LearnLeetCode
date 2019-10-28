package com.lwf.TOP100.normal;


/**
 * author Administrator
 * time 2019-10-28-23:19
 */
public class NumTrees {
    public int numTrees(int n) {
        int[] sums=new int[n+1];
        sums[0]=1;
        sums[1]=1;
//        sums[2]=2; //n=1时的outofrange
        for (int i = 2; i <n+1 ; i++) {
            for (int j = 1; j <i+1 ; j++) {
                sums[i]+=sums[j-1]*sums[i-j];
            }
        }
        return sums[n];
    }
}
