package com.lwf.learn.everyday.coding;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-03 17:12
 */
public class SubtractProductAndSum {
    class Solution {
        public int subtractProductAndSum(int n) {
            int sum=0;
            int multi=1;
            while (n!=0){
                int i = n % 10;
                sum+=i;
                multi*=i;
                n=n/10;
            }
            return multi-sum;
        }
    }
}
