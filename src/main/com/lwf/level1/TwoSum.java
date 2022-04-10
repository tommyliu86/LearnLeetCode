package com.lwf.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-09 17:13
 */
public class TwoSum {
    class Solution {
        /**
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int sub = target - nums[i];
                if (map.containsKey(sub)){
                    return new int[]{map.get(sub),i};
                }else{
                    map.put(nums[i], i);
                }
            }
            return new int[]{0,0};
        }
    }
}
