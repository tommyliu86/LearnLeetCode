package com.lwf.classic.two;

import java.util.Stack;

public class LargestRectangleArea {
    /**
     * 类似接雨水的解体思路，通过栈来保存单调增的下标，在弹出时，通过计算弹出位置的左侧下标~当前i来表示当前弹出位置pop的高度所能生效的矩形位置。
     */
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> index=new Stack<>();
            index.push(-1);
            int max=0;
            for (int i = 0; i < heights.length; i++) {
                int cur = heights[i];
                while (!index.isEmpty() &&getH(index.peek(),heights)>=cur){
                    Integer pop = index.pop();
                    max=Math.max(max,heights[pop]*(i-index.peek()-1));
                }

                index.push(i);
            }
            while (!index.isEmpty()){
                Integer pop = index.pop();
                if (pop!=-1) {
                    max=Math.max(max,heights[pop]*( heights.length-index.peek()));
                }
            }
            return max;
        }
        public int getH(int i,int[] heights){
            if (i==-1) return Integer.MIN_VALUE;
            return  heights[i];
        }
    }
}
