package com.lwf.arithmetic.level2.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-07 19:16
 */
public class Merge {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            List<int[]> list=new ArrayList<>();
            for (int i = 0; i < intervals.length; ) {
                int[] interval = intervals[i];
                int x = interval[0];
                int y=interval[1];
                while (++i<intervals.length&&y>=intervals[i][0]){
                    y=Math.max(y, intervals[i][1]);
                }
                list.add(new int[]{x,y});
            }
            int[][] rtn=new int[list.size()][2];
            for (int i = 0; i < rtn.length; i++) {
                rtn[i]=list.get(i);
            }
            return rtn;
        }
    }
}
