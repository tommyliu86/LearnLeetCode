package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2022/12/19 9:27
 */
public class MinMoves {
    public static void main(String[] args) {
        int[][] matrix=new int[5][5];
        int[] rowSum=new int[matrix.length];
        int[] colSum=new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum[i]+=matrix[i][j];
                colSum[j]+=matrix[i][j];
            }
        }
    }

    class Solution {
        public int minMoves(int[] nums, int k) {
           int[] preSum=new int[nums.length+1];
            List<Integer> g=new ArrayList<>();
            return 1;
        }
    }
    class Solution1 {
        public int minMoves(int[] nums, int k) {
            List<Integer> g = new ArrayList<Integer>();
            List<Integer> preSum = new ArrayList<Integer>();
            preSum.add(0);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    //g中放的是 当前元素 比前一个元素和
                    g.add(i - g.size());
                    preSum.add(preSum.get(preSum.size() - 1) + g.get(g.size() - 1));
                }
            }
            int m = g.size(), res = Integer.MAX_VALUE;
            for (int i = 0; i <= m - k; i++) {
                int mid = i + k / 2;
                int r = g.get(mid);
                res = Math.min(res, (1 - k % 2) * r + (preSum.get(i + k) - preSum.get(mid + 1)) - (preSum.get(mid) - preSum.get(i)));
            }
            return res;
        }
    }


}
