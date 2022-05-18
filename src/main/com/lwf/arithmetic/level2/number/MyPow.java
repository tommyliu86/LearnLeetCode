package com.lwf.arithmetic.level2.number;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 17:16
 */
public class MyPow {
    public static void main(String[] args) {
        int minValue = Integer.MIN_VALUE;
        System.out.println(-3&1);
        System.out.println(minValue>>31);
        System.out.println((minValue>>1)<<1);
    }
    class Solution {
        public double myPow(double x, int n) {
            if (n==0){
                return 1;
            }

            return  pow(x, n);

        }
        public  double pow(double x,int n){
            if (n==1){
                return x;
            }else if (n==-1){
                return 1/x;
            }

            if ((n&1)==1){
                return (n>0? x:(1/x))*pow(x*x,(n>0?( n-1):(n+1))>>1);
            }else{
                return pow(x*x,(n)>>1);
            }
        }
    }
}
