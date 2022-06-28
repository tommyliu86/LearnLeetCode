package com.lwf.learn.everyday.arith.first.d2;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-27 11:29
 */
public class MinimumTotal {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] rtn=new int[triangle.size()];

            for (int i = 0; i < triangle.size(); i++) {
                int pre=0;
                List<Integer> list = triangle.get(i);
                for (int j = 0; j < list.size(); j++) {
                    int temp=rtn[j];
                    rtn[j]=(j==0?rtn[j]:j==list.size()-1?rtn[j-1]: Math.min(pre, rtn[j]))+list.get(j);
                    pre=temp;
                }
            }
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < rtn.length; i++) {
                min=Math.min(min,rtn[i]);
            }
            return min;
        }
    }
}
