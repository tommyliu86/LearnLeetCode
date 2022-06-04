package com.lwf.learn.everyday.dp.level1.d2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 13:50
 */
public class Trap {
    class Solution {
        public int trap(int[] height) {
            int sum = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty()&&height[stack.peek()]<height[i]){
                    Integer pop = stack.pop();
                    if (!stack.isEmpty()){
                        sum+=(Math.min(height[ stack.peek()],height[i])-height[pop])*(i-stack.peek()-1);
                    }
                }
                stack.push(i);

            }
            return sum;
        }

    }
}
