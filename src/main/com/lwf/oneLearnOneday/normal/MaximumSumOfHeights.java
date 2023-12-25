package com.lwf.oneLearnOneday.normal;

import java.util.List;
import java.util.Stack;

/**
 * 2866. 美丽塔 II
 *
 * @author liuwenfei
 * @date 2023/12/21 8:16
 */
public class MaximumSumOfHeights {
    /**
     * 使用单调栈，进行左侧和右侧的两个山峰的数据计算，
     */
    class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            int n = maxHeights.size();
            long[] preSum = new long[n + 1];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                Integer cur = maxHeights.get(i);
                long newCount = preSum[i];
                while (!stack.isEmpty() && maxHeights.get(stack.peek()) > cur) {
                    Integer pop = stack.pop();
                    newCount -= (long) (pop - (stack.isEmpty() ? -1 : stack.peek())) * maxHeights.get(pop);
                }
                newCount += (long) (i - (stack.isEmpty() ? -1 : stack.peek())) * cur;
                preSum[i + 1] = newCount;
                stack.push(i);
            }

            long ans=0;

            long[] postSum = new long[n + 1];
            stack = new Stack<>();
            for (int i = n -1; i>=0; i--) {
                Integer cur = maxHeights.get(i);
                long newCount = postSum[i+1];
                while (!stack.isEmpty() && maxHeights.get(stack.peek()) > cur) {
                    Integer pop = stack.pop();
                    newCount -= (long) ((stack.isEmpty() ? n : stack.peek()) - pop) * maxHeights.get(pop);
                }
                newCount += (long) ((stack.isEmpty() ? n : stack.peek()) - i) * cur;
                postSum[i ] = newCount;
                stack.push(i);
                ans=Math.max(ans,postSum[i]+preSum[i+1]-maxHeights.get(i));
            }
            return  ans;

        }
    }
}
