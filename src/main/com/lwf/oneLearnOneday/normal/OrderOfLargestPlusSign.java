package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2022/11/9 9:18
 */
public class OrderOfLargestPlusSign {
    /**
     * 使用前缀和，然后遍历
     */
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] mine : mines) {
                List<Integer> orDefault = map.getOrDefault(mine[0], new ArrayList<>());
                orDefault.add(mine[1]);
                map.put(mine[0], orDefault);
            }
            int ans = 0;
            int[][][] sums = new int[n + 1][n + 1][2];
            for (int i = 1; i < sums.length; i++) {
                for (int j = 1; j < sums[i].length; j++) {
                    int[] point = sums[i][j];
                    int has = 1;
                    if (map.containsKey(i - 1) && map.get(i - 1).contains(j - 1)) {
                        has = 0;
                    }
                    point[0] = sums[i][j - 1][0] + has;
                    point[1] = sums[i - 1][j][1] + has;

                }
            }
            int m = (n & 1) == 1 ? n : n - 1;
            while (m > 0) {
                for (int i = m; i < sums.length; i++) {
                    for (int j = m; j < sums[i].length; j++) {
                        if ((sums[i - (m / 2)][j][0] - sums[i - (m / 2)][j - m][0] == m) && (sums[i][j - m / 2][1] - sums[i - m][j - m / 2][1] == m)) {
                            return (m + 1) / 2;
                        }
                    }

                }
                m -= 2;
            }
            return 0;
        }
    }
}
