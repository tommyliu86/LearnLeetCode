package com.lwf.oneLearnOneday.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuwenfei
 * @date 2022/10/26 8:45
 */
public class ShortestSubarray {
    /**
     * 滑动窗口+消除负数，类似贪心算法
     */
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            long[] preSums=new long[nums.length+1];
            for (int i = 1; i < preSums.length; i++) {
                preSums[i]=preSums[i-1]+nums[i-1];
            }
            Deque<Integer> deque=new LinkedList<>();
            int min=nums.length+10;
            for (int i = 0; i < preSums.length; i++) {
                while (!deque.isEmpty()&& preSums[i]-preSums[ deque.peekFirst()]>=k){
                    Integer integer = deque.pollFirst();
                    min=Math.min(min,i-integer);
                }
                while (!deque.isEmpty()&&preSums[i]<=preSums[ deque.peekLast()]){
                    deque.pollLast();
                }
                deque.offer(i);
            }
            return min==nums.length+10?-1:min;
        }
    }



    /**
     * 滑动窗口+消除负数，类似贪心算法
     */
    class Solution1 {
        public int shortestSubarray(int[] nums, int k) {
            int left = -1;
            int right = 0;
            int sum = 0;
            int min = nums.length + 10;

            while (right < nums.length) {

                sum += nums[right];
                if (sum<=0){
                    left=right;
                    sum=0;
                    right++;
                    continue;
                }
                if (nums[right]<0){
                    int mi=nums[right];
                    nums[right]=0;
                    for (int i = right-1;mi<0&& i > left; i--) {
                        mi=nums[i]+mi;
                        if (mi<0){
                            nums[i]=0;
                        }else{
                            nums[i]=mi;
                        }
                    }
                }
                if (sum >= k) {
                    while ( sum >= k) {
                        left++;
                        sum -= nums[left];
                    }
                    min = Math.min(min, right - left + 1);
                }

                right++;
            }
            return min == nums.length + 10 ? -1 : min;
        }
    }
}
