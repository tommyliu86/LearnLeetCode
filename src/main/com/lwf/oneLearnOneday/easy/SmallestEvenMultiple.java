package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/4/21 9:20
 */
public class SmallestEvenMultiple {
    /**
     * 求出gcd，然后a*b/gcd即可
     */
    class Solution {
        public int smallestEvenMultiple(int n) {
            int gcd = gcd(2, n);
            return 2*n/gcd;
        }
        public int gcd(int a,int b){
            if (a==0)return b;
            return gcd(b%a,a);
        }
    }
}
