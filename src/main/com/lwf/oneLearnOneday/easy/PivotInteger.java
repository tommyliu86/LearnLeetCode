package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/6/26 8:34
 */
public class PivotInteger {
    class Solution {
        public int pivotInteger(int n) {
            int sum=(1+n)*n/2;
            int sub=0;
            for (int i = 1; i <= n; i++) {
                sub+=i;
                if (sum-sub+i==sub){
                    return i;
                }
            }
            return -1;
        }
    }
}
