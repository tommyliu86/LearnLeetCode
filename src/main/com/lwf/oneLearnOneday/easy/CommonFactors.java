package com.lwf.oneLearnOneday.easy;

public class CommonFactors {
    /**
     * 1.找到最大公约数 GCD
     * 2.查看gcd可以分解成多少不同的组合，枚举即可
     */
    class Solution {
        public int commonFactors(int a, int b) {
            int gcd = gcd(a, b);
            if (gcd==1) return 1;
            int ans=2;
            int i=2;
            while (i*i<=gcd){
                if (gcd%i==0) {
                    ans+=(gcd==i*i?1:2);
                }
                i++;
            }
            return ans;
        }
        public int gcd(int a,int b){
            return b==0?a : gcd(b,a%b);
        }
    }
}
