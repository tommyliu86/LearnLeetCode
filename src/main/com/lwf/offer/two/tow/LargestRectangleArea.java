package com.lwf.offer.two.tow;

import java.util.Stack;

public class LargestRectangleArea {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> indez=new Stack<>();
            int max=0;
            for (int i = 0; i < heights.length; i++) {
                int height = heights[i];
                int subMax=height;

                while (!indez.isEmpty()&&heights[indez.peek()]>=height){
                    indez.pop();
                }
                subMax=Math.max(subMax,height*(i-(indez.isEmpty()?0: indez.peek())));

                max=Math.max(max,subMax);

                indez.push(i);

            }
            if (!indez.isEmpty()){
                int h=indez.pop()
            }
        }
    }
}
