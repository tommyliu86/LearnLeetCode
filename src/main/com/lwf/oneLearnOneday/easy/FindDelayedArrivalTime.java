package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/9/8 9:24
 */
public class FindDelayedArrivalTime {
    /**
     * 除余算法
     */
    class Solution {
        public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
            return (arrivalTime+delayedTime) %24;
        }
    }
}
