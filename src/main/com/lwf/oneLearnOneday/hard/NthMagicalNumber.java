package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2022/11/23 9:12
 */
public class NthMagicalNumber {
    class Solution {
        /**
         * 二分查找需要思考的不是区间内有什么，而是要思考区间外有什么！
         * 从这里看，当找到一个数，他的 cur==n时，因为这个数有可能是有余数的，因此，我们需要去找到<n的第一个数，因此我们在==n时需要再二分，
         * @param n
         * @param a
         * @param b
         * @return
         */
        public int nthMagicalNumber(int n, int a, int b) {
            long left=Math.min(a,b);
            long right=n*left;
           int lcm=lcm(a,b);
           while (left<=right){
               long mid=(left+right)/2;
               long cur= mid/a+mid/b-mid/lcm;
               if (cur>=n){
                    right=mid-1;
               }else{
                   left=mid+1;
               }
           }
           return (int) ((right+1)%1000000007);
        }

        public int lcm(int a,int b){
            return a*b/gcd(a,b);
        }
        public int gcd(int a,int b){
            if (a==0){
                return b;
            }else{
                return gcd(b%a,a);
            }
        }
    }
}
