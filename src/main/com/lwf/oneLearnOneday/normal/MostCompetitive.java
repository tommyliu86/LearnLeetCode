package com.lwf.oneLearnOneday.normal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: liuwenfei
 * @date: 2024/5/24-8:44
 */
public class MostCompetitive {
    /**
     * 单调栈，每个i的位置可以根据当前的位置计算出来最多可以替换到哪个位置，进行单调处理
     */
    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            int s=nums.length;
            Deque<Integer> queue=new LinkedList<>();

            for (int i = 0; i < s; i++) {
                //剩余的元素个数
                int curI= s-i-1;
                while (queue.size()>0&& queue.size()>=k-curI&& queue.peekLast()>nums[i]){
                    queue.pollLast();
                }
                queue.add(nums[i]);
            }
            int[] ans=new int[k];
            for (int i = 0; i < ans.length; i++) {
                ans[i]=queue.poll();
            }
            return ans;

        }
    }
}
