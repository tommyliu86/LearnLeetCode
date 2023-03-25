package com.lwf.offer.two;

import java.util.LinkedList;
import java.util.Queue;

public class DailyTemperatures {
    /**
     * 单调栈来存储要找下一个大于自身的位置，不断查找即可
     */
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Queue<Integer> index=new LinkedList<>();
            int[] ans=new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                int cur = temperatures[i];
                while (!index.isEmpty()&&temperatures[index.peek()]<cur){
                    Integer pop = ((LinkedList<Integer>) index).pop();
                    ans[pop]=i-pop;
                }
                ((LinkedList<Integer>) index).push(i);
            }
            return ans;
        }
    }
}
