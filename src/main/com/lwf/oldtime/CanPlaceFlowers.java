package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-31-23:48
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int start=-1;
        int count=0;
        int i=0;
        for (; i < flowerbed.length&&count<n; i++) {
            if (flowerbed[i]!=0){
                int len=i-start;
                if (len%2==0) len--;
                count=count+len/2;
                start=i+1;
            }
        }
        if (i==flowerbed.length){
            int len=i-start+1;
            if (len%2==0) len--;
            count=count+len/2;
            return count>=n;
        }else   {
            return true;
        }

    }
}
