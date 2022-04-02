package com.lwf.oldtime;

import java.util.HashMap;

/**
 * author Administrator
 * time 2019-08-21-23:19
 * {@link 532.md}
 */
public class FindPairs {
    public int findPairs(int[] nums, int k) {
        if (k<0) return 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        if (k==0) {
            for (Integer v : map.values()) {
                if (v>1)count++;
            }
            return count;
        }

        for (Integer integer : map.keySet()) {
            if (map.containsKey( integer+k)) count++;
            if (map.containsKey(integer-k)) count++;
        }

        return count/2;
    }
}
