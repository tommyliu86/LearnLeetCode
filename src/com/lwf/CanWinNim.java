package com.lwf;

/**
 * author Administrator
 * time 2019-08-01
 */
public class CanWinNim {
    public static void main(String[] args) {
        System.out.println(6 & 4);
    }
    public boolean canWinNim(int n) {
        return n%4!=0;
        //return n&3 1=0；
    }
}
