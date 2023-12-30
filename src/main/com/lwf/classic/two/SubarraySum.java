package com.lwf.classic.two;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/3/2 9:07
 */
public class SubarraySum {
    /**
     * 前缀和+hash，元素有正有负，因此不能直接用滑动窗口
     */
    class Solution {
        public int subarraySum(int[] nums, int k) {
           int sum[]=new int[nums.length+1];
            Map<Integer,Integer> map=new HashMap<>();
            map.put(0,1);
            int ans=0;
            for (int i = 1; i < sum.length; i++) {
                sum[i]=sum[i-1]+nums[i-1];
                  ans+=  map.getOrDefault(   sum[i]-k,0);
                  map.put(sum[i],map.getOrDefault(sum[i],0)+1);
            }
            return ans;
        }
    }
}
