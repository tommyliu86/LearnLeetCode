package com.lwf.learn.everyday.coding.level2.d2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-19 17:57
 */
public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> index = new Stack<>();
            int[] rtn = new int[temperatures.length];
            for (int i = temperatures.length - 1; i >= 0; i--) {
                while (!index.isEmpty() && temperatures[index.peek()] <= temperatures[i]) {
                    index.pop();
                }
                rtn[i] = index.isEmpty()?0:( index.peek() - i );
                index.add(i);
            }
            return rtn;
        }
    }
}
