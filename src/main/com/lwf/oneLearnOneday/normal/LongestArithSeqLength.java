package com.lwf.oneLearnOneday.normal;

public class LongestArithSeqLength {
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            //i表示当前长度i，j表示等差为j的长度，每次计算都记录最大max即可。
            int[][] lns=new int[nums.length][1001];
            int ans=0;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    int gap = nums[i] - nums[j] + 500;
                    lns[i][gap]=Math.max(lns[i][gap], lns[j][gap]+1);
                    ans=Math.max(ans,lns[i][gap]);
                }
            }
            return ans+1;
        }
    }
}
