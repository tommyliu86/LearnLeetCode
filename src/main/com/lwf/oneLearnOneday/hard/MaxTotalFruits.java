package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2023/5/4 9:30
 */
public class MaxTotalFruits {
    /**
     * 二分查找求sum，然后通过计算左右边界坐标进行计算。
     */
    class Solution {
        public int maxTotalFruits(int[][] fruits, int startPos, int k) {
            int[] sums = new int[2 * k + 2];

            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + find(fruits, i + startPos - k - 1);
            }
            int l = 1;
            int m = k + 1;
            int max = 0;
            while (l + k < sums.length) {
                int left = m - l;
                int right = k - left;
                max = Math.max(max, Math.max(sums[m + right / 2] - sums[m - left - 1], sums[m + right] - sums[m - left / 2 - 1]));
                l++;
            }
            return max;
        }

        private int find(int[][] fruits, int i) {
            int l = 0, r = fruits.length - 1;
            if (i < 0 || i > fruits[r][0]) return 0;
            while (l <= r) {
                int m = (l + r) / 2;
                if (fruits[m][0] == i) {
                    return fruits[m][1];
                } else if (fruits[m][0] > i) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return 0;

        }
    }
}
