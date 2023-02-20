package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2023/2/15 9:21
 */
public class IsGoodArray {
    /**
     * 数论？？
     * 普适思路是，两个数 i,j，他们的任意倍数相减==1，那么这里需要考虑，倍数刚好相邻的数，假设i，j都不等于1，那需要如何实现？
     * 也就是已知： x=a*b，x>1,x-1=c*d,x>1，
     */
    class Solution {
        public boolean isGoodArray(int[] nums) {
            int gcd=nums[0];
            for (int i = 1; i < nums.length; i++) {
                if ((gcd=gcd1(gcd,nums[i]))==1){
                    return true;
                }
            }
            return false;
        }
        public int gcd(int x,int y){
            return x!=0?gcd(y%x,x):y;
        }
        public int gcd1(int x,int y){
            while (x!=0){
                int temp=y%x;
                y=x;
                x=temp;
            }
            return y;
        }
    }
}
