package com.lwf.classic.two.tow;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/4/18 9:23
 */
public class LargestRectangleArea {
    /**
     * 用栈找左右边界，类似与接雨水的方式。
     */
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> indez=new Stack<>();
            int max=0;
            for (int i = 0; i < heights.length; i++) {
                int height = heights[i];
                while (!indez.isEmpty()&& heights[ indez.peek()]>=height){
                    Integer pop = indez.pop();
                    int h=indez.isEmpty()?-1:indez.peek();
                    max=Math.max(max,heights[pop]*(i-h-1));
                }
                indez.push(i);
            }
            while (!indez.isEmpty()){
                Integer pop = indez.pop();
                int h=indez.isEmpty()?-1:indez.peek();
                max=Math.max(max,heights[pop]*(heights.length-h-1));
            }
            return max;
        }
    }
}
