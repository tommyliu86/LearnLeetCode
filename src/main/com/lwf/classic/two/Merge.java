package com.lwf.classic.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LCR 074. 合并区间
 * @author liuwenfei
 * @date 2023/11/10 18:11
 */
public class Merge {
    /**
     * 排序后合并即可
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> list=new ArrayList<>();
            Arrays.sort(intervals, Comparator.comparing(a->a[0]));

            for (int i = 0; i < intervals.length; i++) {
                int[] interval = intervals[i];
                int end = interval[1];
                int j=i+1;
                while (j<intervals.length&&end>=intervals[j][0]){
                    end=Math.max( intervals[j][1],end);
                    j++;
                }
                list.add(new int[]{interval[0],end});
                i=j-1;
            }
            int[][] ans=new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                ans[i]=list.get(i);
            }
            return ans;
        }
    }
}
