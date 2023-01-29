package com.lwf.offer.one;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/1/29 11:14
 */
public class LengthOfLongestSubstring {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> map=new HashMap<>();
            int max=0;
            int left=-1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                    left=Math.max(left, map.getOrDefault(c,left));
                    max=Math.max(max,i-left);

                map.put(c,i);
            }
            return max;
        }
    }
}
