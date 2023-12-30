package com.lwf.classic.two.tow;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            int sum=0;
            map.put(sum,1);
            int ans=0;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
                if (map.containsKey(sum-k)){
                    ans+=map.get(sum-k);
                }
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
            return ans;
        }
    }
}
