package com.lwf.classic.two;

import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/3/17 17:49
 */
public class FindMinDifference {
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            timePoints.sort(String::compareTo);
            int pre=getMinute(timePoints.get(0));
            int total = getMinute("24:00");
            int min=(pre+ total - getMinute(timePoints.get(timePoints.size()-1)))%total;

            for (int i = 1; i < timePoints.size(); i++) {
                int cur = getMinute( timePoints.get(i));
                min=Math.min(min,cur-pre);
                pre=cur;
            }
            return min;
        }
        public int getMinute(String s){
            String[] split = s.split(":");
            return Integer.valueOf( split[0])*60+Integer.valueOf(split[1]);
        }
    }
}
