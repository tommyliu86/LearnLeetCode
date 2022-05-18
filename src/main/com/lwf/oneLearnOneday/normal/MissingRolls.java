package com.lwf.oneLearnOneday.normal;

public class MissingRolls {
    class Solution {
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
