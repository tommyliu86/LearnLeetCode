package com.lwf.classic.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LCR 075. 数组的相对排序
 *
 * @author liuwenfei
 * @date 2023/11/10 18:18
 */
public class RelativeSortArray {
    /**
     * 排序
     */
    class Solution1 {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr2.length; i++) {
                map.put(arr2[i], i);
            }
            Integer[] arr = new Integer[arr1.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr1[i];
            }
            Arrays.sort(arr, (a, b) -> {
                Integer a1 = map.getOrDefault(a, a + 2000);
                Integer b1 = map.getOrDefault(b, b + 2000);

                return Integer.compare(a1, b1);

            });
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = arr[i];
            }
            return arr1;
        }
    }

    /**
     * 直接找位置
     * 通过记录每个位置的数字的个数，来进行直接排序
     */
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {

            int[] counts = new int[1001];
            for (int i = 0; i < arr1.length; i++) {
                counts[arr1[i]]++;
            }
            int[] ans = new int[arr1.length];
            int i = 0, j = 0;
            while (i < arr1.length && j < arr2.length) {
                int cur = arr2[j++];
                int count = counts[cur];
                counts[cur] = 0;
                for (int i1 = 0; i1 < count; i1++) {
                    ans[i++] = cur;
                }
            }
            j = 0;
            while (i < arr1.length) {
                while (counts[j] == 0) {
                    j++;
                }
                int count = counts[j];
                counts[j] = 0;
                for (int i1 = 0; i1 < count; i1++) {
                    ans[i++] = j;
                }
            }
            return ans;
        }
    }
}
