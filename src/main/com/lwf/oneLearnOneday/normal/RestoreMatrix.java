package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/3/14 11:03
 */
public class RestoreMatrix {
    /**
     * 贪心，每个位置（i，j）的位置，可以放进去的最大值，应该是行，列的最小值，每次动态更新行列剩余了多少
     * 我们就可以在遍历时的每个位置找到剩余的行、列和，就可以组装出一组符合要求的数据
     */
    class Solution {
        public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
            int[][] ans=new int[rowSum.length][colSum.length];
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    ans[i][j]=Math.min(rowSum[i],colSum[j]);
                    rowSum[i]-=ans[i][j];
                    colSum[j]-=ans[i][j];
                }
            }
            return ans;
        }
    }
}
