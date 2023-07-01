package com.lwf.oneLearnOneday.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * liuwu
 * 2023/7/1-22:48
 * TwoSum
 **/
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map=new HashMap();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target- nums[i])){
                    return new int[]{map.get(target-nums[i]),i};
                }
                map.put(nums[i],i);
            }
            return new int[]{0,0};
        }
    }
}
