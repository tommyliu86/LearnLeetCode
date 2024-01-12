package com.lwf.oneLearnOneday.hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1944. 队列中可以看到的人数
 * @author liuwenfei
 * @date 2024/1/5 8:38
 */
public class CanSeePersonsCount {
    public static void main(String[] args) {
        new Solution().canSeePersonsCount(new int[]{10,6,8,5,11,9});
    }
    /**
     * 单调递减栈，保持单调减小，则减小的是看不到的，放进来的这个，是前面一个可以看到的，单调递减可以找到向下看，也就是中间的都比两边的小
     *
     */
 static   class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int[] ans=new int[heights.length];
            Stack<Integer> queue=new Stack<>();
            int i=0;
            while (i<heights.length){
                while (!queue.isEmpty()&&heights[ queue.peek()]<heights[i]){
                    Integer poll = queue.pop();
                    ans[poll]++;
                }
                if (!queue.isEmpty()){
                   ans[ queue.peek()]++;
                }
                queue.push(i++);
            }
            return ans;
        }
    }
}
