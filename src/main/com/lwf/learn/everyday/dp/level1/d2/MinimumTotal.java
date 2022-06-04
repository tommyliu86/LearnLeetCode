package com.lwf.learn.everyday.dp.level1.d2;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-04 10:58
 */
public class MinimumTotal {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> pre = triangle.get(i - 1);
                List<Integer> cur = triangle.get(i);
                for (int j = 0; j < cur.size(); j++) {
                    cur.set(j,cur.get(j)+(Math.min(j==0?pre.get(0):pre.get(j-1),j==pre.size()?pre.get(j-1):pre.get(j))));
                }
            }
            List<Integer> list = triangle.get(triangle.size() - 1);
            int min=list.get(0);
            for (int i = 1; i < list.size(); i++) {
                min=Math.min(min,list.get(i));
            }
            return min;
        }
    }
}
