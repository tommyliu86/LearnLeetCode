package com.lwf.oneLearnOneday.easy;

/**
 * @author: liuwenfei
 * @date: 2024/4/28-19:31
 */
public class FindColumnWidth {
    class Solution {
        public int[] findColumnWidth(int[][] grid) {
            int[] ans=new int[grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int i1 = grid[i][j];
                    ans[j]=Math.max(ans[j],String.valueOf(i1).length());
                }
            }
            return ans;
        }
    }
}
