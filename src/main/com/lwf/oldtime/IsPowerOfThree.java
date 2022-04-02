package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-01
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(27 % 3);
        int n=27;
        System.out.println(n /= 3);
    }
    public boolean isPowerOfThree(int n) {
        if (n<1) return false;
        if(n==1) return true;
        while (n!=1){
            if (n%3!=0){
                return false;
            }
            n/=3;
        }
        return true;
    }
}
