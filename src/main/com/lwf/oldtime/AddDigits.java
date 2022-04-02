package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-07-31
 * {@link /md/258.md} {@see /md/258.md}
 */
public class AddDigits {
    public int addDigits(int num) {
        while (num/10>0){
            int temp=num;
            int sum=0;
            while (temp!=0){
                sum+=temp%10;
                temp/=10;
            }
            num=sum;
        }
        return num;
    }
    public int addDigits1(int num) {
        if (num==0) return 0;
       if (num%9==0) return 9;
       else {
           return num%9;
       }

    }
}
