package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * 2477. 到达首都的最少油耗
 * @author liuwenfei
 * @date 2023/12/5 11:28
 */
public class MinimumFuelCost {
    /**
     * 拓扑排序，找叶子节点
     * curNode  当前人数p，已走路径r，  nextNode p+1，（p+k-1）/k+r，需要多少辆车都需要加一
     */
    class Solution {
        public long minimumFuelCost(int[][] roads, int seats) {
            int[] degree=new int[roads.length+1];
            List<Integer>[] lists=new List[roads.length+1];
            for (int i = 0; i < lists.length; i++) {
                lists[i]=new ArrayList();
            }
            for (int i = 0; i < roads.length; i++) {
                degree[roads[i][0]]++;
                degree[roads[i][1]]++;
                lists[roads[i][0]].add(roads[i][1]);
                lists[roads[i][1]].add(roads[i][0]);
            }
            Queue<Integer> queue=new LinkedList<>();
            long[][] state=new long[degree.length][2];
            for (int i = 0; i < degree.length; i++) {
                state[i][0]=1;
                if (degree[i]==1&&i!=0){
                    queue.offer(i);
                    degree[i]--;
                }
            }

            while (!queue.isEmpty()){
                Integer poll = queue.poll();
                List<Integer> list = lists[poll];
                for (Integer i : list) {
                    if (degree[i]<=0)
                        continue;

                    state[i][0]+=state[poll][0];
                    state[i][1]+=((state[poll][0]+seats-1)/seats)+state[poll][1];
                    if (--degree[i]==1&&i!=0){
                        degree[i]--;
                        queue.offer(i);
                    }
                }
            }
            return state[0][1];
        }
    }
}
