package com.lwf.learn.everyday.coding.level2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-18 10:36
 */
public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> index=new Stack<>();
            int[] rtn=new int[temperatures.length];
            for (int i = temperatures.length - 1; i >= 0; i--) {
                if (index.isEmpty()){
                    rtn[i]=0;
                    index.push(i);
                }else{
                    int t = temperatures[i];
                    while (!index.isEmpty()&& t>temperatures[ index.peek()]){
                        index.pop();
                    }
                    rtn[i]=index.isEmpty()?0:(index.peek()-i);
                    index.push(i);
                }
            }
            return rtn;
        }
    }
}
