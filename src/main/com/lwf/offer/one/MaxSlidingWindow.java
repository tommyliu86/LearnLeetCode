package com.lwf.offer.one;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/2/8 19:07
 */
public class MaxSlidingWindow {
    /**
     * 单调队列，i<j， if j>i,则i肯定不会是窗口中的大值，因此我们维护一个最大值的减小单调队列即可。
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> index=new LinkedList<>();
            int i=0;
            while (i<k-1){
                while (!index.isEmpty()&&nums[ index.peekLast()]<=nums[i]){
                    index.pollLast();
                }
                index.offer(i);
                i++;
            }
            int[] ans=new int[nums.length-k+1];
            int j=0;
            while (i<nums.length){
                while (!index.isEmpty()&&nums[ index.peekLast()]<=nums[i]){
                    index.pollLast();
                }
                index.offer(i);
                while (!index.isEmpty()&&index.peek()<i-k+1){
                    index.poll();
                }
                ans[j++]=nums[ index.peek()];
                i++;
            }
            return ans;
        }
    }
    /**
     * 优先队列
     */
    class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<int[]> priorityQueue=new PriorityQueue<int[]>((a,b)->Integer.compare(b[0],a[0]));

            int j=0;
            while (j<k-1){
                priorityQueue.offer(new int[]{nums[j],j});
            }
            int[] ans=new int[nums.length-k+1];
            int a=0;
            while (j<nums.length){
                priorityQueue.offer(new int[]{nums[j],j});
                while (priorityQueue.peek()[1]<j-k+1){
                    priorityQueue.poll();
                }
                ans[a++]=priorityQueue.peek()[0];

                j++;
            }
            return ans;
        }
    }
}
