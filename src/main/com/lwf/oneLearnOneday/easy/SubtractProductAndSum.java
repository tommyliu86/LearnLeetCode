package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/8/9 8:55
 */
public class SubtractProductAndSum {
    class Solution {
        public int subtractProductAndSum(int n) {
            int sum=0,multi=1;
            while (n!=0){
                int cur=n%10;
                n/=10;
                sum+=cur;
                multi*=cur;
            }
            return multi-sum;
        }
    }
}
