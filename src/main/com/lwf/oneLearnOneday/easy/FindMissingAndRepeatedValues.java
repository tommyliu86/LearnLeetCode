package com.lwf.oneLearnOneday.easy;

/**
 * 2965. 找出缺失和重复的数字
 *
 * @author: liuwenfei
 * @date: 2024/5/31-9:12
 */
public class FindMissingAndRepeatedValues {
    /**
     * 一次遍历，统计次数
     */
    class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            int[] count=new int[n*n+1];
            int[] ans=new int[2];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < n; j++) {
                    count[ grid[i][j]]++;
                    if (count[ grid[i][j]]==2){
                        ans[0]=grid[i][j];
                    }
                }
            }
            for (int i = 1; i < count.length; i++) {
                if (count[i]==0){
                    ans[1]=i;
                    break;
                }
            }
            return ans;
        }
    }
}
