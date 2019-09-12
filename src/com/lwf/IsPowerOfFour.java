package com.lwf;

/**
 * author Administrator
 * time 2019-08-02
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        if(num<1) return false;
        if((num&(num-1))!=0) return false;
        int n=0;
        while(num!=0){
            n++;
            num=num>>1;
        }
        return (n&1)==0;
    }
}
