package com.lwf;

/**
 * {@link 441.md}
 */
public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(8) * Math.sqrt(2));
        System.out.println(new ArrangeCoins().arrangeCoins(8));
    }
    public int arrangeCoins(int n) {

        int k=(int)(Math.sqrt(n)*Math.sqrt(2));
        int m= ((k&1)==0?(k/2)*(k+1):((k+1)/2)*k);

        if(m>n) {
            return k-1;
        }
        else{
            return k;
        }
    }
}
