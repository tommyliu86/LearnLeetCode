package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2023/8/10 8:49
 */
public class MinFallingPathSum {
    /**
     * 动态规划 + 最小值常数
     * <p>
     * 思路：使用动态规划的思想，从上到下的计算每个位置的最小下降路径和。每次计算时，只需要保留当前位置的最小值和第二小值即可，减少空间复杂度。
     * <p>
     * 时间复杂度：O(n^2)，其中 n 为二维数组的边长。需要遍历整个二维数组，计算每个位置的最小下降路径和。
     * 空间复杂度：O(1)，只需要常数级别的额外空间来存储最小值和第二小值。
     */
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int n = grid.length;
            if (n == 1) { //如果只有1行，则直接返回该行的元素
                return grid[0][0];
            }

            int min1 = -1; //用于保存当前行的最小值的列索引
            int min2 = -1; //用于保存当前行的第二小值的列索引

            for (int i = 0; i < n; i++) { //遍历所有行
                int[] curs = grid[i]; //获取当前行的元素数组
                int cmin1 = -1; //保存当前行的最小值的列索引
                int cmin2 = -1; //保存当前行的第二小值的列索引
                for (int j = 0; j < curs.length; j++) { //遍历当前行的所有列
                    if (i != 0) { //对比上一轮计算的结果
                        if (min1 == j) { //如果当前列是上一轮的最小值列
                            curs[j] += grid[i - 1][min2]; //则当前位置的值加上上一行第二小值的值
                        } else {
                            curs[j] += grid[i - 1][min1]; //否则，当前位置的值加上上一行最小值的值
                        }
                    }
                    if (cmin1 == -1 || curs[j] <= curs[cmin1]) { //如果当前位置的值小于最小值或者cmin1未初始化
                        int temp = cmin1; //交换最小值与第二小值的索引
                        cmin1 = j;
                        cmin2 = temp;
                    } else if (cmin2 == -1 || curs[j] < curs[cmin2]) { //如果当前位置的值介于最小值与第二小值之间
                        cmin2 = j; //更新第二小值的索引
                    }
                }
                min1 = cmin1; //将当前行的最小值的列索引赋值给min1
                min2 = cmin2; //将当前行的第二小值的列索引赋值给min2
            }

            return grid[n - 1][min1]; //返回最后一行的最小下降路径和
        }
    }

}
