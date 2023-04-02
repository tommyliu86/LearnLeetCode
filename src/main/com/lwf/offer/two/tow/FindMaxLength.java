package com.lwf.offer.two.tow;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {
    class Solution {
        public int findMaxLength(int[] nums) {

            Map<Integer,Integer> map = new HashMap<>();
            int sum=0;
            map.put(sum,-1);
            int l=0;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i]==0?-1:1;
                if (map.containsKey(sum)){
                    l=Math.max(l,i-map.get(sum));
                }else{
                    map.put(sum,i);
                }

            }
            return l;
        }
    }
}
