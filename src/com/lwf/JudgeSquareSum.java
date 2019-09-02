package com.lwf;

/**
 * author Administrator
 * time 2019-09-02-22:49
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c/2); i++) {
            if (Math.pow((int) Math.sqrt(c - (i * i)),2)==c-i*i){
                return true;
            }
        }
        return false;
    }
    public boolean judgeSquareSum1(int c) {
        int min=0;int max=(int) Math.sqrt(c);
        while (min<=max){
            int sum=min*min+max*max;
            if (sum<c){
                min++;
            }
            if (sum>c) max--;
            if (sum==c) return true;
        }
        return false;
    }
}
