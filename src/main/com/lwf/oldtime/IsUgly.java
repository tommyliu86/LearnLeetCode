package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-07-31
 * {@link 263.md}
 */
public class IsUgly {
    public boolean isUgly(int num) {
        if (num<1) return false;
        while (num%5==0){
            num=num/5;
        }
        while(num%3==0){
            num/=3;
        }
        if ((num&(num-1))==0){
            return true;
        }else {
            return false;
        }
    }
}
