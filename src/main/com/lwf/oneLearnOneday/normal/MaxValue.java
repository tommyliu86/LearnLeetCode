package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/1/4 9:20
 */
public class MaxValue {
    /**
     * dp类型问题，找路线到终点让价值最大
     */
    class Solution {
        public int maxValue(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j]=Math.max(i==0?0:grid[i-1][j],j==0?0:grid[i][j-1]);
                }
            }
            return grid[grid.length-1][grid[0].length-1];
        }
    }

    /**
     * int类型越界。。
     */
    class Solution1 {
        public int maxValue(int n, int index, int maxSum) {

            int left = index + 1;
            int right = n - index;
            int min = 1;
            int max = maxSum;
            while (min <= max) {
                int mid = max - (max - min) / 2;
                long sum = sum(left, right, mid);
                if (sum > maxSum) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return max;
        }

        public long sum(int l, int r, int i) {
            return subSum(l, i) + subSum(r, i) - i;
        }

        public long subSum(int l, int i) {
            if (i <= l) {
                return (long) (l - i) + ((long) (1 + i) * i / 2);
            } else {
                return (((long) i + (long) (i - l + 1)) * l / 2);
            }
        }
    }
}
