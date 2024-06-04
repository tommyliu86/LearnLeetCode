package com.lwf.oneLearnOneday.easy;

/**
 * 1103. 分糖果 II
 *
 * @author: liuwenfei
 * @date: 2024/6/3-8:22
 */
public class DistributeCandies2 {
    /**
     * 暴力解法，直接遍历糖果。
     */
    class Solution {
        public int[] distributeCandies(int candies, int num_people) {

            int i=0;
            int[] ans=new int [num_people];
            while (candies>0){
                int cur=i%num_people;
                ans[cur]+=Math.min(candies, i+1);
                candies-=i+1;

                i++;
            }
            return ans;
        }
    }
}
