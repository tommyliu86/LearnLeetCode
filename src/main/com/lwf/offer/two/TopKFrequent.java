package com.lwf.offer.two;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/6/29 9:42
 */
public class TopKFrequent {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map=new HashMap<>();
            int[] counts=new int[nums.length];
            int[] ns=new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])){
                    counts[map.get(nums[i])]++;
                }else{
                    int size = map.size();
                    map.put(nums[i],size);
                    ns[size]=nums[i];
                    counts[size]++;
                }
            }
            PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
            for (int i = 0; i < map.size(); i++) {
                queue.offer(new int[]{counts[i],ns[i]});
                while (queue.size()>k){
                    queue.poll();
                }
            }
            int[] ans=new int[k];
            for (int i = 0; i < ans.length; i++) {
                int[] poll = queue.poll();

                ans[i]=poll[1];
            }
            return ans;
        }
    }
    class Solution1 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map=new HashMap<>();
            int[] counts=new int[nums.length];
            int[] ns=new int[nums.length];
            Integer[] indez=new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                indez[i]=i;
                if (map.containsKey(nums[i])){
                    counts[map.get(nums[i])]++;
                }else{
                    int size = map.size();
                    map.put(nums[i],size);
                    ns[size]=nums[i];
                    counts[size]++;
                }
            }
            Arrays.sort(indez,(a,b)->Integer.compare(counts[b], counts[a]));
            int[] ans=new int[k];
            for (int i = 0; i < ans.length; i++) {
                ans[i]=ns[ indez[i]];
            }
            return ans;
        }
    }
}
