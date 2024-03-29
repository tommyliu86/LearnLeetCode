package com.lwf.learn.everyday.coding.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-08 15:18
 */
public class MaximumWealth {
    class Solution {
        public int maximumWealth(int[][] accounts) {
            int max=0;
            for (int i = 0; i < accounts.length; i++) {
                int sum=0;
                for (int j = 0; j < accounts[i].length; j++) {
                    sum+=accounts[i][j];
                }
                max=Math.max(sum,max);
            }
            return max;
        }
    }
}
