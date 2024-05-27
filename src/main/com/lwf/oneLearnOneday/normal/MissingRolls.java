package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 2028. 找出缺失的观测数据
 */
public class MissingRolls {
    /**
     * n个数的和是sum，找到一个sum的组合
     */
    class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int m = rolls.length;
            int nSum = (m + n) * mean - Arrays.stream(rolls).sum();
            if (6*n<nSum||nSum<n){
                return new int[0];
            }
            int i = nSum / n;
            int j = nSum % n;
            int[] ans=new int[n];
            for (int k = 0; k < n-j; k++) {
                ans[k]=i;
            }
            for (int i1 = n-j; i1 < n; i1++) {
                ans[i1]=i+1;
            }
            return ans;
        }
    }
    class Solution1 {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int sum = (rolls.length + n) * mean;
            for (int i : rolls) {
                sum -= i;
            }
            if (sum > n * 6 || sum < n) {
                return new int[0];
            }
            int[] rtn = new int[n];

            int every = sum / n;
            int remain = sum % n;
            for (int i = 0; i < rtn.length; i++) {
                rtn[i] = every + ((remain--) > 0 ? 1 : 0);
            }
            return rtn;
        }
    }

}
