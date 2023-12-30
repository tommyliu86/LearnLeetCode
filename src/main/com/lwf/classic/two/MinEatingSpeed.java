package com.lwf.classic.two;

/**
 * LCR 073. 爱吃香蕉的狒狒
 * @author liuwenfei
 * @date 2023/11/10 16:33
 */
public class MinEatingSpeed {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int i=1,j=1000_000_000;
            while (i<=j){
                int m=i+(j-i)/2;
                if (times(m,piles)>h){
                    i=m+1;
                }else{
                    j=m-1;
                }
            }
            return i;
        }
        public int times(int speed,int[] piles){
            int ans=0;
            for (int pile : piles) {
                ans+=(pile+(speed-1))/speed;
            }
            return ans;
        }
    }
}
