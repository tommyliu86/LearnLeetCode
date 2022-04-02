package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-31-23:20
 */
public class MaxCount {
    public int maxCount(int m,int n,int[][] ops){
        for (int i = 0; i < ops.length; i++) {
            m=Math.min(m,ops[i][0]);
            n=Math.min(n,ops[i][1]);
        }
        return m*n;
    }

}
