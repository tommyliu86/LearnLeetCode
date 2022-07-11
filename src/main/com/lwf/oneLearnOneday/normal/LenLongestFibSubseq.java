package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

public class LenLongestFibSubseq {
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            int n = arr.length;
            Map<Integer, Integer> v2i = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                v2i.put(arr[i], i);
            }
            int[][] mark = new int[n][n];
            int max = 0;
            for (int i = 2; i < mark.length; i++) {
                int k3 = arr[i];
                for (int j = 1; j < i; j++) {
                    int k2 = arr[j];
                    Integer k1i = v2i.getOrDefault(k3 - k2, n);
                    if (k1i < j) {
                        mark[i][j] = mark[j][k1i] == 0 ? 3 : (mark[j][k1i] + 1);
                        max = Math.max(max, mark[i][j]);
                    }
                }
            }
            return max;
        }
    }
}
