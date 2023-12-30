package com.lwf.classic.two.tow;

import java.util.List;

public class FindMinDifference {
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            timePoints.sort(String::compareTo);
            int min=sub(timePoints.get(0), timePoints.get(timePoints.size()-1));
            for (int i = 1; i < timePoints.size(); i++) {
                min=Math.min(min,sub(timePoints.get(i),timePoints.get(i-1)));
            }
            return min;
        }
        public int sub(String max,String min){
            int max1 = getMin(max);
            int min1 = getMin(min);
            return (max1+24*60-min1)%(24*60);
        }
        public int getMin(String s){
            String[] split = s.split(":");
            return Integer.valueOf( split[0])*60+Integer.valueOf(split[1]);
        }
    }
}
