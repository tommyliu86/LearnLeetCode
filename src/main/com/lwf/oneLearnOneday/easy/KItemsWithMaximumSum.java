package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/7/5 8:32
 */
public class KItemsWithMaximumSum {
    class Solution {
        public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
            return numOnes>=k?k:(numZeros>=(k-numOnes)?numOnes:(numOnes-(k-numOnes-numZeros)));
        }
    }
}
