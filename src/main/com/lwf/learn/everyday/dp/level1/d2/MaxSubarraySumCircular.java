package com.lwf.learn.everyday.dp.level1.d2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-27 10:50
 */
public class MaxSubarraySumCircular {
    /**
     * 动态规划
     */
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int[] pre=new int[nums.length*2+1];
            for (int i = 1; i < pre.length; i++) {
                pre[i]=pre[i-1]+nums[i%nums.length];
            }


            Deque<Integer> index=new LinkedList<>();

            int sub=Integer.MIN_VALUE;
            for (int i = pre.length - 1; i >= 0; i--) {

                while (!index.isEmpty()&& index.getLast()-i>nums.length-1){
                   sub=Math.max(sub, pre[index.removeLast()]-pre[i]);
                }

                while (!index.isEmpty()&& pre[i]>=pre[ index.getFirst()]){
                  sub=Math.max(sub,  pre[index.removeFirst()]-pre[i]);
                }
                index.push(i);

                if (index.size()>1){

                    sub=Math.max(sub, pre[index.getLast()]-pre[index.getFirst()]);
                }
            }
            return sub;
        }

    }

    /**
     * 暴力解法
     */
    class Solution1 {
        public int maxSubarraySumCircular(int[] nums) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int left = 0;
            int right = 0;
            while (left < nums.length && (right < nums.length * 2 - 1)) {
                if (right > nums.length - 1 && right % nums.length == left) {
                    left++;
                    right = left;
                    sum = 0;
                } else {

                    sum += nums[right % nums.length];
                    max = Math.max(max, sum);
                    if (sum <= 0) {
                        sum = 0;
                        left = right + 1;
                    }
                    right++;
                }
            }
            return max;
        }
    }
}
