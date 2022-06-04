package com.lwf.learn.everyday.data.level2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 16:28
 */
public class EraseOverlapIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparing(a->a[0]));
            int left=0;
            int right=1;
            int count=0;
            while (right<intervals.length){
                if (intervals[left][1]<=intervals[right][0]){
                    left=right;
                    right++;
                }else{
                    if (intervals[left][1]>intervals[right][1]){
                        left=right;
                        right++;
                    }else{
                        right++;
                    }
                    count++;
                }
            }
            return count;
        }
    }
}
