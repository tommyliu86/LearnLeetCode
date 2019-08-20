package com.lwf;

import java.util.List;

/**
 * author Administrator
 * time 2019-08-21-0:17
 * {@link 507.md}
 */
public class CheckPerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num<=1) return false;
        int sqrt= (int)Math.sqrt(num);
        int sum=0;
        while (sqrt!=1){
            if (num%sqrt==0){
                sum+=sqrt;
                sum+=num/sqrt;
            }
        }
        return num==sum+1;
    }
}
