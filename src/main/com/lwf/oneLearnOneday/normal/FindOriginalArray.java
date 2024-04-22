package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2007. 从双倍数组中还原原数组
 *
 * @author: liuwenfei
 * @date: 2024/4/18-8:38
 */
public class FindOriginalArray {
    public static void main(String[] args) {
        System.out.println("123".replace("|", "_"));
    }
    /**
     * hash表，进行一次遍历，使用hash来进行计数
     */
    class Solution {
        public int[] findOriginalArray(int[] changed) {
            if (changed.length % 2 == 1) {
                return new int[0];
            }
            Arrays.sort(changed);
            int[] ans = new int[changed.length / 2];
            Map<Integer, Integer> map = new HashMap<>();
            int i = 0;
            for (int j : changed) {
                if (j % 2 == 0 && map.getOrDefault(j / 2, 0) > 0) {
                    ans[i++] = j / 2;
                    map.computeIfPresent(j / 2, (k, v) -> v-1);
                } else {
                    map.compute(j, (k,v)->v==null?1:(v+1));
                }
            }
            return i == ans.length ? ans : new int[0];
        }
    }
}
