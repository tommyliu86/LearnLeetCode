package com.lwf.learn.everyday.coding.level2.d2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-20 16:41
 */
public class KClosest {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            Arrays.sort(points, Comparator.comparingInt(a -> a[0] * a[0] + a[1] * a[1]));
            int[][] rtn=new int[k][2];
            for (int i = 0; i < rtn.length; i++) {
                rtn[i]=points[i];
            }
            return rtn;
        }
    }
}
