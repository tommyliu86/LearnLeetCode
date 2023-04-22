package com.lwf.offer.two.tow;

import java.util.Stack;

public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> indez=new Stack<>();
            int[] ans=new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                int t = temperatures[i];
                while (!indez.isEmpty()&&temperatures[ indez.peek()]<t){
                    Integer pop = indez.pop();
                    ans[ pop]=i-pop;
                }
                indez.push(i);
            }
            return ans;
        }
    }
}
