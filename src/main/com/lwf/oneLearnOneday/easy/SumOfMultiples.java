package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/10/17 8:42
 */
public class SumOfMultiples {
    /**
     * 容斥原理，等差数列求和公式直接计算
     */
    class Solution {
        public int sumOfMultiples(int n) {
            int ans=0;
            ans=sum(n,3)+sum(n,5)+sum(n,7)-sum(n,3*5)-sum(n,3*7)-sum(n,5*7)+sum(n,3*5*7);
            return ans;
        }
        public int sum(int n,int c){
            return c*((n/c)+1)*(n/c)/2;
        }
    }
    /**
     * 直接遍历
     */
    class Solution1 {
        public int sumOfMultiples(int n) {
            int ans=0;
            for (int i = 1; i <= n; i++) {
                if (i%3==0||i%5==0||i%7==0)
                    ans+=i;
            }
            return ans;
        }
    }
}
