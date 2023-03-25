package com.lwf.oneLearnOneday.easy;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/2/28 9:04
 */
public class MergeSimilarItems {
    /**
     * hash+排序
     */
    class Solution {
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < items1.length; i++) {
                map.put(items1[i][0],items1[i][1]);
            }
            for (int i = 0; i < items2.length; i++) {
                map.put(items2[i][0], map.getOrDefault(items2[i][0],0)+items2[i][1]);
            }
            List<List<Integer>> ans=new ArrayList<>();
            map.forEach((k,v)->{
                ans.add(new ArrayList<>(Arrays.asList(k,v)));
            });
            ans.sort(Comparator.comparing(a->a.get(0)));
            return ans;
        }
    }

    /**
     * 排序+双指针
     */
    class Solution1 {
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            Arrays.sort(items1, Comparator.comparing(a -> a[0]));
            Arrays.sort(items2, Comparator.comparing(a -> a[0]));
            int i1 = 0, i2 = 0;
            List<List<Integer>> ans = new ArrayList<>();
            while (i1 < items1.length || i2 < items2.length) {
                int c1 = i1 < items1.length ? items1[i1][0] : Integer.MAX_VALUE;
                int c2 = i2 < items2.length ? items2[i2][0] : Integer.MAX_VALUE;
                if (c1 > c2) {
                    ans.add(new ArrayList<>(Arrays.asList(items2[i2][0], items2[i2][1])));
                    i2++;
                } else if (c1 == c2) {
                    ans.add(new ArrayList<>(Arrays.asList(items2[i2][0], items2[i2][1] + items2[i1][1])));
                    i2++;
                    i1++;
                } else {
                    ans.add(new ArrayList<>(Arrays.asList(items2[i1][0], items2[i1][1])));
                    i1++;
                }

            }
            return ans;
        }
    }
}
