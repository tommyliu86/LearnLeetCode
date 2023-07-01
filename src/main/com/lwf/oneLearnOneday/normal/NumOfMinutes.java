package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumOfMinutes {
    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            Map<Integer, List<Integer>> indez=new HashMap<>();
            for (int i = 0; i < manager.length; i++) {
                List<Integer> list = indez.getOrDefault(manager[i], new ArrayList<>());
                list.add(i);
                indez.put(manager[i],list);
            }
            int max=0;
            return max(headID,indez,informTime);

        }
        public int max(int i,Map<Integer,List<Integer>> indez,int[] informTime){
            if (!indez.containsKey(i)) {
                return informTime[i];
            }
            int rtn=0;
            List<Integer> list = indez.get(i);
            for (int j = 0; j < list.size(); j++) {
                rtn=Math.max(rtn,max(list.get(j),indez,informTime));
            }
            return rtn+informTime[i];
        }
    }
}
