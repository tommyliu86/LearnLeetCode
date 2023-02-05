package com.lwf.offer.one;

public class MyPow {
    /**
     * 递归,注意写法。。。
     */
    class Solution1 {
        public double myPow(double x, int n) {
            if (n==0) return 1d;
            double a=0;
            if (n>0){
                if (n%2==0){

                    return  (a= myPow(x,n/2))*a;
                }else{

                    return x*(a=myPow(x,(n-1)/2))*a;
                }
            }else{
                if (n%2==0){
                    return (a=myPow(x,n/2))*a;
                }else{
                    return (1/x)*(a=myPow(x,(n+1)/2))*a;
                }
            }

        }
    }

}
