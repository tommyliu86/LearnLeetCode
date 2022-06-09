package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-08 09:13
 */
public class IsBoomerang {
    class Solution {
        public boolean isBoomerang(int[][] points) {
            return (points[2][0]-points[1][0])*(points[1][1]-points[0][1])!=(points[1][0]-points[0][0])*(points[2][1]-points[1][1]);
        }
    }
}
