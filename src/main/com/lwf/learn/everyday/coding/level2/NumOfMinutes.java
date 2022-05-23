package com.lwf.learn.everyday.coding.level2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-23 16:35
 */
public class NumOfMinutes {
    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            Map<Integer, List<Integer>> map=new HashMap<>();
            for (int i = 0; i < manager.length; i++) {
                int key = manager[i];
                List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                list.add(i);
                map.put(key,list);
            }
            Queue<Integer> queue=new LinkedList<>();
            ((LinkedList<Integer>) queue).add(headID);
            int max=0;
            while (!queue.isEmpty()){
                Integer poll = queue.poll();
                List<Integer> subList = map.get(poll);
                if (subList!=null){
                    for (Integer integer : subList) {
                        informTime[integer]+=informTime[poll];
                        if (map.containsKey(integer)){
                            queue.add(integer);
                        }else{
                            max=Math.min(max,informTime[integer]);
                        }
                    }
                }
            }
            return max;
        }
    }
}
