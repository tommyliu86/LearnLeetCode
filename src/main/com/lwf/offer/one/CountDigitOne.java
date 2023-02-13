package com.lwf.offer.one;

public class CountDigitOne {
    /**
     * 按照每一个位上为1来计算所有的可能数字组合。枚举
     */
    class Solution {
        public int countDigitOne(int n) {
            long i=0;
            long k=1;

            while (k<=n){
                int l=(int)( n/k);
                int r=(int) (n%k);
                //k位数上的数字大小
                int cur= l%10;
                //当前k位之前有多少高位
                l/=10;
                if (cur>1){
                    i+=(l+1)*k;
                }else if (cur==1){
                    i+=l*k+r+1;
                }else{
                    i+=l*k;
                }
                k*=10;
            }

            return (int) i;
        }


    }
}
