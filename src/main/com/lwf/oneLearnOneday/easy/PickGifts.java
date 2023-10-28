package com.lwf.oneLearnOneday.easy;

import java.util.PriorityQueue;

/**
 * 2558. 从数量最多的堆取走礼物
 * https://leetcode.cn/problems/take-gifts-from-the-richest-pile/solutions/2501655/yuan-di-dui-hua-o1-kong-jian-fu-ti-dan-p-fzdh/
 */
public class PickGifts {
    class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->Integer.compare(b,a));
            for (int gift : gifts) {
                queue.offer(gift);
            }
            while (k>0){
                k--;
                Integer poll = queue.poll();
                if (poll>1){
                    queue.offer((int)Math.pow(poll,0.5));
                }else{
                    queue.offer(poll);
                    break;
                }
            }
            long ans=0;
            for (Integer integer : queue) {
                ans+=integer;
            }
            return ans;

        }
    }
}
