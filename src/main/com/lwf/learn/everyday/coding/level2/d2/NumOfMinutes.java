package com.lwf.learn.everyday.coding.level2.d2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-23 17:19
 */
public class NumOfMinutes {
    /**
     * 广度遍历
     */
    class Solution1 {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            Map<Integer,List<Integer>> map=new HashMap<>();
            for (int i = 0; i < manager.length; i++) {
                int header = manager[i];
                if (header!=-1){
                    List<Integer> list = map.getOrDefault(header, new ArrayList<>());
                    list.add(i);
                    map.put(header,list);
                }
            }
            Queue<int[]> queue=new LinkedList<>();
            queue.add(new int[]{headID,0});

            int max=0;

            while (!queue.isEmpty()){
                int[] pop = ((LinkedList<int[]>) queue).pop();
                if (map.containsKey(pop[0])){
                    List<Integer> list = map.get(pop[0]);
                    for (int i = 0; i < list.size(); i++) {
                        queue.add(new int[]{list.get(i),informTime[pop[0]]+pop[1]});
                    }
                }else{
                    max=Math.max(max,pop[1]);
                }
            }
            return max;
        }
    }
    /**
     * 深度遍历，递归获取子树的最大时间
     */
    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            //key是领导，list是下属list
            Map<Integer, List<Integer>> map=new HashMap<>();
            for (int i = 0; i < manager.length; i++) {
                int leader = manager[i];
                if (leader!=-1){
                    List<Integer> list = map.getOrDefault(leader, new ArrayList<>());
                    list.add(i);
                    map.put(leader,list);
                }
            }
            return getTime(headID,map,informTime);
        }
        public int getTime(int cur,Map<Integer,List<Integer>> map,int[] time){
            if (!map.containsKey(cur)){
                return 0;
            }
            List<Integer> list = map.get(cur);
            int max=0;
            for (int i = 0; i < list.size(); i++) {
                int subTime = getTime(list.get(i), map, time);
                max=Math.max(subTime,max);
            }
            return max+time[cur];
        }
    }
}
