package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-26 15:43
 */
public class Merge {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparing(a->a[0]));
            int i=0;
            List<int[]> list=new ArrayList<>();
            while (i<intervals.length){
                int[] t1 = intervals[i];
                int[] sub=new int[2];
                sub[0]=t1[0];
                int end=t1[1];
                int j=i+1;
                while (j<intervals.length&& end>=intervals[j][0]){
                    end=Math.max( intervals[j][1],end);
                    j++;
                }
                sub[1]=end;
                i=j;
                list.add(sub);
            }
            return list.toArray(new  int[list.size()][2]);
        }
    }
}
