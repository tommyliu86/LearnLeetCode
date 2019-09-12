package com.lwf;

/**
 * author Administrator
 * time 2019-08-05
 */
public class GetSum {
    public int getSum(int a, int b) {
        int mid=a^b;
        int upgrade=a&b;
        while (upgrade!=0){
            upgrade=upgrade<<1;
            int temp=mid^upgrade;
            upgrade=mid&upgrade;
            mid=temp;
        }
        return mid;
    }
}
