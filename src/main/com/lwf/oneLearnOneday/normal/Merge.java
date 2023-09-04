package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    /**
     * 排序后遍历
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

            List<int[]> ans=new ArrayList<>();
            for (int i = 0; i < intervals.length; ) {
                int start=intervals[i][0];
                int end=intervals[i][1];
                int j=i+1;
                while (j<intervals.length&&intervals[j][0]<=end){
                    end=Math.max(end,intervals[j][1]);
                    j++;
                }
                ans.add(new int[]{start,end});
                i=j;
            }

            int[][] arrays=new int[ans.size()][2];
            for (int i = 0; i < arrays.length; i++) {
                arrays[i]=ans.get(i);
            }
            return arrays;
        }
    }
}
