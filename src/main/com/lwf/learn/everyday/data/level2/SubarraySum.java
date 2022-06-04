package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 18:04
 */
public class SubarraySum {
    /**
     * 前缀和的正向考虑，使用，i为起点，向后计算，因此需要两次遍历
     */
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] sum=new int[nums.length+1];
            Map<Integer, List< Integer>> map=new HashMap<>();
            for (int i = 1; i < sum.length; i++) {
                sum[i]=sum[i-1]+nums[i-1];
                List<Integer> list = map.getOrDefault(sum[i], new ArrayList<>());
                list.add(i);
                map.put(sum[i],list);
            }
            int rtn=0;
            for (int i = 1; i < sum.length; i++) {
                int need=k+sum[i-1];
                if (map.containsKey(need)){
                    List<Integer> list = map.get(need);
                    int j=0;
                    while (list.get(j)<i){
                        j++;
                    }
                    rtn+=list.size()-j;
                }

            }
            return rtn;
        }
    }
}
