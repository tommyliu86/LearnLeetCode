package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuwenfei
 * @date 2023/3/30 9:04
 */
public class MaxWidthOfVerticalArea {
    class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
            int max=0;
            for (int i = 1; i < points.length; i++) {
                max=Math.max(max,points[i][0]-points[i-1][0]);
            }
            return max;
        }
    }
}
