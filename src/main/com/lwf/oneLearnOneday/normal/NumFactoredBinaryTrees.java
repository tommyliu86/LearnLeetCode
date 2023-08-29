package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liuwenfei
 * @date 2023/8/29 8:52
 */
public class NumFactoredBinaryTrees {
    /**
     * dp 动态规划
     */
    class Solution {
        public int numFactoredBinaryTrees(int[] arr) {
            Arrays.sort(arr);
            long[] dps = new long[arr.length];
            Arrays.fill(dps, 1);
            Map<Integer, Integer> indez = new HashMap<>();

            long ans = 0;
            int mod = 1000_000_007;
            for (int i = 0; i < dps.length; i++) {
                indez.put(arr[i], i);
                int cur = arr[i];
                for (int j = 0; j < i && arr[j] * arr[j] <= arr[i]; j++) {
                    int pre = arr[j];
                    if (cur % pre == 0 && indez.containsKey(cur / pre)) {
                        Integer index = indez.get(cur / pre);
                        dps[i] += index == j ? dps[j] * dps[j] : 2 * dps[j] * dps[index];
                    }
                }
                ans = (ans + dps[i]) % mod;
            }
            return (int) ans;
        }
    }
}
