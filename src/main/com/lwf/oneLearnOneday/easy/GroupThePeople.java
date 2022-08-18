package com.lwf.oneLearnOneday.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {
    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            Map<Integer,List<Integer>> map=new HashMap<>();
            for (int i = 0; i < groupSizes.length; i++) {
                int key = groupSizes[i];
                List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                list.add(i);
            }
            List<List<Integer>> rtn=new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                Integer size = entry.getKey();
                List<Integer> value = entry.getValue();
                int i=0;
                while (i<value.size()){
                    List<Integer> sub=new ArrayList<>();
                    for (int j = 0; j < size; j++) {
                        sub.add(value.get( i+j));
                    }
                    i+=size;
                    rtn.add(sub);
                }
            }
            return rtn;
        }
    }
}
