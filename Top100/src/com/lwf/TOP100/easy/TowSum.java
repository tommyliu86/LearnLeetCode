package com.lwf.TOP100.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * author Administrator
 * time 2019-09-03-22:50
 */
public class TowSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int retain=target-nums[i];
            if (map.containsKey(retain)) {

                return new int[]{map.get(retain),i};
            }else {
                map.putIfAbsent(nums[i],i);
            }
        }
        return null;
    }
}
