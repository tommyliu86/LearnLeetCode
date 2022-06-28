package com.lwf.learn.everyday.data.level2.d2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 16:55
 */
public class EraseOverlapIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
            int count=0;
            int i=0;
            while (i<intervals.length){
                int[] first=intervals[i];
                int end=first[1];

                int j=i+1;
                while (j<intervals.length&& intervals[j][0]<end){
                    end=Math.min(end,intervals[j][1]);
                    j++;
                    count++;
                }
                i=j;
            }
            return count;
        }
    }
}
