package com.lwf.oneLearnOneday.normal;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liuwenfei
 * @date 2023/7/20 8:27
 */
public class MaxSubarraySumCircular {
    /**
     * 单调队列，保存前缀和的最小单调增，这样可以直接获取到当前i前面的前缀最小值，
     */
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int l = nums.length;
            int[] ns=new int[l *2+1];

            int max=Integer.MIN_VALUE;
            int sum=0;
            Deque<Integer> deque=new LinkedList<>();

            for (int k = 0; k < l * 2; k++) {
                while (!deque.isEmpty()&&k- deque.peekFirst()>l){
                    deque.pollFirst();
                }
                sum+=nums[k%l];
                ns[k]=sum;
                max=Math.max(max,sum-(deque.isEmpty()?0:ns[deque.peekFirst()]));

                while (!deque.isEmpty()&&ns[deque.peekLast()]>=sum){
                    deque.pollLast();
                }
                deque.offer(k);
            }
            return max;
        }
    }
    /**
     * 分情况考虑：情况1：子数组在数组范围，则按照正常的子数组和求解，
     * 情况2：子数组跨越数组，那么肯定是  j~n  + 0~j-1 这种取值方法，因此我们也可以直接这样求解出跨越的大小
     */
    class Solution1 {
        public int maxSubarraySumCircular(int[] nums) {
            int max=Integer.MIN_VALUE,sum=0,total=0;
            for (int i = 0; i < nums.length; i++) {
                total+=nums[i];
                max=Math.max(max,nums[i]);
                sum+=nums[i];
                if (sum<=0){
                    sum=0;
                }else{
                    max=Math.max(max,sum);
                }
            }
            int presum=0,preMax=Integer.MIN_VALUE;
            for (int i = 0; i < nums.length-1; i++) {
                presum+=nums[i];
                preMax=Math.max(preMax,presum);
                max=Math.max( total-presum+preMax,max);
            }
            return max;

        }
    }
}
