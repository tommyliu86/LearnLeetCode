package com.lwf.learn.everyday.data.level2.d2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 17:55
 */
public class SubarraySum {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            //key 是前缀和的值，value是出现过的次数，
            Map<Integer,Integer> map=new HashMap<>();
            //当和==k时，差值是0，因此需要map中先存储一个0的key。
            map.put(0,1);
            int count=0;
            int pre=0;
            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                pre+=cur;
                if (map.containsKey(pre-k)){
                    count+=map.get(pre-k);
                }
                map.put(pre,map.getOrDefault(pre,0)+1);
            }
            return count;
        }
    }
}
