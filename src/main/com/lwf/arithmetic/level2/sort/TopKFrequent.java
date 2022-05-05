package com.lwf.arithmetic.level2.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-05 10:41
 */
public class TopKFrequent {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            }
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a,b)->Integer.compare(b[1],a[1]));
            for (Map.Entry<Integer, Integer> i : map.entrySet()) {
                priorityQueue.add(new int[]{i.getKey(),i.getValue()});
            }
            int[] rtn=new int[k];
            for (int i = 0; i < k; i++) {
                int[] poll = priorityQueue.poll();
                rtn[i]=poll[0];
            }
            return  rtn;
        }
    }
}
