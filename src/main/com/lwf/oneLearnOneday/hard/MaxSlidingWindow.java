package com.lwf.oneLearnOneday.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liuwenfei
 * @date 2022/12/5 19:52
 */
public class MaxSlidingWindow {
    /**
     * 滑动窗口 求解 ，使用双端队列滑动即可
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] ans=new int[nums.length+1-k];
            Deque<Integer> indexes=new LinkedList<>();
            int i=0;
            while (i<nums.length){

                int cur = nums[i];
                while (!indexes.isEmpty()&& cur>=nums[indexes.peekLast()]){
                    indexes.pollLast();
                }
                indexes.offer(i);
                if (i+1- indexes.peekFirst()>k){
                    indexes.pollFirst();
                }
                if (i+1>=k){
                    ans[i+1-k]=nums[indexes.peekFirst()];
                }
                i++;
            }
            return ans;
        }
    }
}
