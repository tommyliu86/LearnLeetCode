package com.lwf.TOP100.easy;

/**
 * author Administrator
 * time 2019-09-09-23:54
 */
public class ClimbStairs {
    public int climbStairs(int n) {

        if (n<3) return n;
        int pre=1;
        int next=2;
        int i=3;
        while (i<=n){
            int temp=next;
            next+=pre;
            pre=temp;
            i++;
        }
        return next;
    }
}
