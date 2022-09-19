package com.lwf.oneLearnOneday.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuwenfei
 * @date 2022/9/19 8:50
 */
public class FrequencySort {
    class Solution {
        public int[] frequencySort(int[] nums) {
            Map<Integer,Integer> v2Count=new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int v = nums[i];
                v2Count.put(v,v2Count.getOrDefault(v,0)+1);
            }
            List<Map.Entry<Integer, Integer>> collect = v2Count.entrySet().stream().sorted((a, b) -> {
                if (Integer.compare(a.getValue(), b.getValue()) == 0) {
                    return Integer.compare(b.getKey(), a.getKey());
                } else {
                    return Integer.compare(a.getValue(), b.getValue());
                }
            }).collect(Collectors.toList());
            int[] rtn=new int[nums.length];
            int i=0;
            for (Map.Entry<Integer, Integer> entry : collect) {
                Integer v = entry.getKey();
                int end=i+entry.getValue();
                for (; i < end; i++) {
                    rtn[i]=v;
                }
            }
            return rtn;
        }
    }
}
