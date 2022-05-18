package com.lwf.learn.everyday.dp.level1;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-16 15:25
 */
public class MinimumTotal {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> pre = triangle.get(i - 1);
                List<Integer> cur = triangle.get(i);
                for (int j = 0; j < cur.size(); j++) {
                    cur.set(j,cur.get(j)+(j==0?pre.get(0):j==pre.size()?pre.get(j-1): Math.min(pre.get(j),pre.get(j-1))));
                }
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
