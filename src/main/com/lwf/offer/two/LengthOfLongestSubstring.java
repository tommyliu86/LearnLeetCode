package com.lwf.offer.two;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/3/3 10:50
 */
public class LengthOfLongestSubstring {
    /**
     * 滑动窗口
     */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> map=new HashMap<>();
            int i=0,j=0;
            int max=0;
            while (j<s.length()){
                char c = s.charAt(j);
                if (map.containsKey(c)){
                    i=Math.max(i, map.get(c)+1);
                }
                max=Math.max(max,j-i+1);
                    map.put(c,j++);

            }

            return max;
        }
    }
}
