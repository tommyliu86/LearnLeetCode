package com.lwf.oneLearnOneday.hard;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/7/24 9:16
 */
public class Trap {
    /**
     * 单调栈,
     */
    class Solution {
        public int trap(int[] height) {
            Stack<Integer> stack = new Stack<>();
            int i = 0,ans=0;
            while (i < height.length) {
                while (!stack.isEmpty() && height[i] >= height[ stack.peek()]) {
                    Integer pop = stack.pop();
                    ans+=stack.isEmpty()?0: (Math.min(height[i],height[stack.peek()])-height[pop])*(i-stack.peek()-1);
                }
                stack.push(i);
            }
            return ans;
        }
    }

    /**
     * 左右最大高度 ，然后遍历
     */
    class Solution1 {
        public int trap(int[] height) {
            int[] ml = new int[height.length], mr = new int[height.length];
            int m = 0;
            for (int i = 0; i < height.length; i++) {
                ml[i] = m;
                m = Math.max(m, height[i]);
            }
            m = 0;
            for (int i = height.length - 1; i >= 0; i--) {
                mr[i] = m;
                m = Math.max(m, height[i]);
            }
            int ans = 0;
            for (int i = 0; i < height.length; i++) {
                ans += Math.max(0, Math.min(ml[i], mr[i]) - height[i]);
            }
            return ans;
        }
    }
}
