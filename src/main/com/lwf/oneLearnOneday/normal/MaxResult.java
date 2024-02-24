package com.lwf.oneLearnOneday.normal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1696. 跳跃游戏 VI
 * @author liuwenfei
 * @date 2024/2/5 19:29
 */
public class MaxResult {
    /**
     * 如何找到滑动窗口内的最大值，是使用双端队列+单调栈的方式，使用双端队列存储单调递增/递减的数据，这样就可以永远保存滑动窗口中的数据！
     * 原因：假设找最大值，那么单调递增队列中，i<j时，f（j）>f(i)成立，因此只要i在滑动窗口中，j肯定在！
     */
    class Solution {
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            int[] sum=new int[n];

          //双端队列+单调栈
            Deque<Integer> indez=new LinkedList<>();
            for (int i = 0; i < sum.length; i++) {
                while (!indez.isEmpty()&& indez.peekFirst()<i-k) {
                    indez.removeFirst();
                }
                sum[i]=nums[i]+(indez.isEmpty()?0:sum[indez.peekFirst()]);
                while (!indez.isEmpty()&&sum[i]>=sum[indez.peekLast()]){
                    indez.removeLast();
                }
                indez.offer(i);
            }
            return sum[n-1];
        }
        public int maxResult1(int[] nums, int k) {
            int n = nums.length;
            int[] sum=new int[n];

            //1.暴力，直接遍历前k个。
            //2.优化，保存前k个，使用堆排序，会导致nlogn的复杂度，超时
            PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)-> b.compareTo(a));
            for (int i = 0; i < sum.length; i++) {
                sum[i]=nums[i]+(queue.isEmpty()?0:queue.peek());
                if (queue.size()>=k) {
                   queue.remove( sum[i-k]);
                }
                queue.offer(sum[i]);
            }
            return sum[n-1];
        }
    }
}
