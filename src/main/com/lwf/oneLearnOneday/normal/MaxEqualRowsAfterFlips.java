package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/5/15 10:13
 */
public class MaxEqualRowsAfterFlips {
    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {

            int max = 1;
            Map<String, Integer> counts = new HashMap<>();
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < matrix.length; i++) {
                int[] cols = matrix[i];
                String str1 = getStr(cols, false);
                String key;
                int count;
                if (counts.containsKey(str1)) {
                    key = str1;
                    count = counts.get(str1) + 1;
                } else if (map.containsKey(str1)) {
                    key = map.get(str1);
                    count = counts.get(key) + 1;
                } else {
                    key=str1;
                    count=1;
                    String str2 = getStr(cols, true);
                    map.put(str2, key);
                }
                counts.put(key, count);
                max = Math.max(max, counts.get(key));

            }
            return max;
        }

        public String getStr(int[] cols, boolean reverse) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < cols.length; i++) {
                if (reverse) {
                    stringBuilder.append(cols[i] ^ 1);
                } else {
                    stringBuilder.append(cols[i]);
                }
            }
            return stringBuilder.toString();
        }
    }
}
