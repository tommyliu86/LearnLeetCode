package com.lwf.oneLearnOneday.easy;

public class BusyStudent {
    class Solution {
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int [] counts=new int[1001];
            int min=0;
            int max=0;
            for (int i = 0; i < startTime.length; i++) {
               min=Math.min(min, startTime[i]);
               counts[startTime[i]]++;
               max=Math.max(max,endTime[i]);
               counts[endTime[i]]--;
            }
            for (int i = min; i < max+1; i++) {
                counts[i]+=counts[i-1];
            }
            return counts[queryTime];
        }
    }
}
