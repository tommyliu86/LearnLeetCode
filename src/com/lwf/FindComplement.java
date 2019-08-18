package com.lwf;

/**
 * author Administrator
 * time 2019-08-18-22:37
 * {@link 476.md}
 */
public class FindComplement {

    public static void main(String[] args) {
        System.out.println(new FindComplement().findComplement(5));
    }
    public int findComplement(int num) {
    int bitLength=0;
    int n=num;
    while (n!=0){
        bitLength++;
        n=n>>1;
    }
    return num^(int) (Math.pow(2,bitLength)-1);
    }
}
