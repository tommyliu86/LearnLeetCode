package com.lwf.oneLearnOneday.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/1/13 9:22
 */
public class RearrangeCharacters {
    /**
     * hash计数统计
     */
    class Solution {
        public int rearrangeCharacters(String s, String target) {
           int[] counts=new int[26];
            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i)-'a']++;
            }
            int ans=Integer.MAX_VALUE;
            Map<Integer,Integer> targetMap=new HashMap<>();
            for (int i = 0; i < target.length(); i++) {
                targetMap.put(target.charAt(i)-'a',targetMap.getOrDefault(target.charAt(i)-'a',0)+1);
            }
            for (Map.Entry<Integer, Integer> entry : targetMap.entrySet()) {
               if (counts[entry.getKey()]==0){
                   return 0;
               }
               ans=Math.min(ans, counts[entry.getKey()]/entry.getValue());
            }
            return ans;
        }
    }
}
