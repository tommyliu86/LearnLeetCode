package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/10/6 17:07
 */
public class ThreeEqualParts {
    class Solution {
        public int[] threeEqualParts(int[] arr) {
            long count = Arrays.stream(arr).filter(i -> i == 1).count();
            if (count == 0) {
                return new int[]{0, 2};
            }
            if (count % 3 != 0) {
                return new int[]{-1, -1};
            }

            int l = (int) count / 3;
            int r = arr.length - 1;

            int[][] gaps = new int[3][2];
            gaps[2][1] = arr.length - 1;
            int lL = 0;
            while (arr[lL] == 0) {
                lL++;
            }
            gaps[0][0] = lL;
            int rL = 0;
            while (arr[r] == 0) {
                r--;
                rL++;
            }
            for (int i = 2; i > 0; i--) {
                int i3 = 0;
                while (i3 < l) {
                    if (arr[r] == 1) {
                        i3++;
                    }
                    r--;
                }
                int max = r + 1;
                gaps[i][0] = max;
                while (arr[r] != 1) {
                    r--;
                }
                int min = r + rL;
                if (min >= max) {
                    return new int[]{-1, -1};
                }
                gaps[i - 1][1] = min;

            }
            if (gaps[0][1] - gaps[0][0] != gaps[1][1] - gaps[1][0] || gaps[0][1] - gaps[0][0] != gaps[2][1] - gaps[2][0]) {
                return new int[]{-1, -1};
            }
            int i1 = 0, i2 = gaps[1][0], i3 = gaps[2][0];
            for (int i = 0; i < gaps[0][1] - gaps[0][0]; i++) {
                if (arr[i1] != arr[i2] || arr[i1] != arr[i3]) {
                    return new int[]{-1, -1};
                }
                i1++;
                i2++;
                i3++;
            }
            return new int[]{gaps[0][1], gaps[1][1] + 1};
        }
    }
}
