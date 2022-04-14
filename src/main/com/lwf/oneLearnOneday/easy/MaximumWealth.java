package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-14 09:17
 */
public class MaximumWealth {
    class Solution {
        public int maximumWealth(int[][] accounts) {
            int max=0;
            for (int i = 0; i < accounts.length; i++) {
                max=Math.max(max,max(accounts[i]));
            }
            return max;
        }
        private int max(int[] ints){
            int sum=0;
            for (int i = 0; i < ints.length; i++) {
                sum+=ints[i];
            }
            return sum;
        }
    }
}
