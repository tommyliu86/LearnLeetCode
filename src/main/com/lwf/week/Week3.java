package com.lwf.week;

import java.sql.SQLOutput;
import java.util.*;

public class Week3 {
    public static void main(String[] args) {
        System.out.println(3|1);
    }

    /**
     * 使用二进制来标识行中的0、1分布，然后遍历1-》1<<column ，这样可以获取到所有列被选中的情况(穷举所有)，
     * 使用其中1的数量==cols的来与每行进行 或 |，如果结果不变，表示当前的枚举值会把当前行变成全0
     * 记录每次的列选举结果的值，找出最大即可
     */
    class Solution {
        public int maximumRows(int[][] m, int cols) {
            int row = m.length;
            int col = m[0].length;
            int[] rows = new int[row];
            for (int i = 0; i < row; i++) {
                int state = 0;
                for (int j = 0; j < col; j++) {

                    state = (state << 1) | m[i][j];
                }
                rows[i] = state;
            }
           int max=0;
            for (int i = 1; i < (1<< col); i++) {
                if (Integer.bitCount(i)!=cols){
                    continue;
                }
                int state = 0;
                for (int j = 0; j < row; j++) {
                    if ((rows[j] | i) == i) {
                        state++;
                    }
                }
                max=Math.max(state,max);
            }
            return max;
        }


    }

    class Solution3 {
        public int maximumRows(int[][] mat, int cols) {
            int[][] columns = new int[mat[0].length][2];
            for (int i = 0; i < mat[0].length; i++) {
                columns[i][0] = i;
                for (int j = 0; j < mat.length; j++) {
                    columns[i][1] += mat[j][i];
                }
            }
            Arrays.sort(columns, (a, b) -> {
                return Integer.compare(b[1], a[1]);
            });
            int[] sums = new int[mat.length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    sums[i] += mat[i][j];
                }
            }
            for (int i = 0; i < cols; i++) {
                int col = columns[i][0];
                for (int j = 0; j < mat.length; j++) {
                    if (mat[j][col] == 1) {
                        sums[j]--;

                        mat[j][col] = 0;
                    }
                }
            }
            int rtn = 0;
            for (int i = 0; i < sums.length; i++) {
                if (sums[i] == 0) {
                    rtn++;
                }
            }
            return rtn;
        }
    }

    class Solution2 {
        public boolean isStrictlyPalindromic(int n) {
            for (int i = 2; i < n; i++) {
                int[] ints = new int[n];
                int j = 0;
                int k = n;
                while (k != 0) {
                    ints[j++] = k % i;
                    k /= i;
                }
                if (isOk(ints, 0, j - 1)) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isOk(int[] ints, int l, int r) {
            while (l < r && ints[l] == ints[r]) {
                l++;
                r--;
            }
            return l >= r;
        }
    }

    class Solution1 {
        public boolean findSubarrays(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int sum = nums[0] + nums[1];
            set.add(sum);
            for (int i = 2; i < nums.length; i++) {
                sum = sum + nums[i] - nums[i - 2];
                if (set.contains(sum)) {
                    return true;
                } else {
                    set.add(sum);
                }
            }
            return false;
        }
    }
}
