package com.lwf.learn.everyday.first.day12;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-11 09:29
 */
public class MinimumTotal {
    /**
     * 动态规划，直接修改原数组，空间复杂度O（1）
     */
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {

            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> sum = triangle.get(i-1);
                List<Integer> list = triangle.get(i);
                list.set(0,sum.get(0)+list.get(0));
                for (int j = 1; j < list.size()-1; j++) {
                    list.set(j,list.get(j)+Math.min(sum.get(j),sum.get(j-1)));
                }
                list.set(list.size()-1,sum.get(sum.size()-1)+list.get(list.size()-1));
            }
            List<Integer> list = triangle.get(triangle.size() - 1);
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                min=Math.min(min,list.get(i));
            }
            return min;
        }
    }
}
