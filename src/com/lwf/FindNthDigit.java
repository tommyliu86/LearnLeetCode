package com.lwf;

/**
 * author Administrator
 * time 2019-08-06
 */
public class FindNthDigit {
    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit1(17));
    }

    /**
     * 暴力破解，会超时
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int k=1;
        n--;
        while (n>0){
            n=n-getlength(k);
            k++;

        }

        if (n==0){
            return k/(int) Math.pow(10,getlength(k)-1);
        }else{
            int rtn=0;
            k=k-1;
            for (int i = n; i <0 ; i++) {
                rtn=k%10;
                k/=10;
            }
        return rtn;
        }
    }
    private int getlength(int i){
        int length=0;
        while(i!=0){
            length++;
            i/=10;
        }
        return length;
    }

    /**
     * 递推计算
     * @param n
     * @return
     */
    public int findNthDigit1(int n) {
        int maxi=0;
        int i=1;
        while(n>maxi+i*(Math.pow(10,i)-Math.pow(10,i-1))) {
            maxi+=i*(Math.pow(10,i)-Math.pow(10,i-1));
            i++;
        }
        n-=maxi;
        n--;
        int remain=n%i;
        int counter=n/i;
        int inwhich=(int) Math.pow(10,i-1)+counter;

            int rtn=0;

            for (int j = 0; j <i-remain ; j++) {
                rtn=inwhich%10;
                inwhich/=10;
            }
            return rtn;
        }
    }


