package com.lwf.oneLearnOneday.normal;

import java.util.PriorityQueue;

/**
 * @author liuwenfei
 * @date 2023/7/25 8:45
 */
public class HalveArray {
    /**
     * 优先队列解题
     */
    class Solution {
        public int halveArray(int[] nums) {
            double sum=0,ans=0;
            PriorityQueue<Double> queue=new PriorityQueue<>((a,b)->b.compareTo(a));
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
                queue.offer((double) nums[i]);
            }
            double diff=0;
            while (diff*2<sum){
                ans++;
                double poll = queue.poll();
                poll/=2;
                diff+=poll;
                queue.offer(poll);
            }
            return (int) ans;
        }
    }
}
