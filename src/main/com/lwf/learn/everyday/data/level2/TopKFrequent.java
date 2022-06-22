package com.lwf.learn.everyday.data.level2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-13 18:33
 */
public class TopKFrequent {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }

            PriorityQueue<int[]> queue=new PriorityQueue<int[]>(Comparator.comparing( a->-a[1]));
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                queue.add(new int[]{entry.getKey(),entry.getValue()});

            }
            int[] rtn=new int[k];
            for (int i = 0; i < rtn.length; i++) {
                rtn[i]=queue.poll()[0];
            }
            return rtn;
        }
    }
}
