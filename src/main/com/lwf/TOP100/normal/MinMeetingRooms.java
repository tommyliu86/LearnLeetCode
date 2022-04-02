package com.lwf.TOP100.normal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/meeting-rooms-ii/
 * 253. 会议室 II
 * @author: liuwenfei14
 * @date: 2022-02-15 10:35
 */
public class MinMeetingRooms {
    /**
     * 暴力解法，排序开始时间，对比每个后续会议的开始时间是否小于前面会议的结束时间，如果有，则表示两个会议之间有时间重叠，则需要的会议室数量+1
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] start=new int[intervals.length];
        int[] end=new int[intervals.length];
        int max=0;
        for (int i = 0; i < intervals.length; i++) {
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
            int currentMax=0;
            for (int j = 0; j < i; j++) {
                if (start[i]<end[j]){
                    currentMax++;
                }

            }
            max=Math.max(max,currentMax);
        }
        return max+1;
    }
}
