package com.lwf.oneLearnOneday.normal;

public class NumPairsDivisibleBy60 {
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int[] marks=new int[60];
            int ans=0;
            for (int i = 0; i < time.length; i++) {
                int cur = time[i] % 60;
                ans+=marks[(60-cur)%60];
                marks[cur]++;
            }
            return ans;
        }
    }
}
