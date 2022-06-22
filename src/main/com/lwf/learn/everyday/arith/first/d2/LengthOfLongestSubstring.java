package com.lwf.learn.everyday.arith.first.d2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-18 14:42
 */
public class LengthOfLongestSubstring {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            int l = 0;
            int r = 0;
            int max = 0;
            while (r < chars.length) {
                map.put(chars[r], map.getOrDefault(chars[r], 0) + 1);
                if (map.get(chars[r]) > 1) {
                    max = Math.max(max, r - l);
                    while (map.get(chars[r]) > 1) {
                        map.put(chars[l], map.get(chars[l]) - 1);
                        l++;
                    }
                }else{
                    max = Math.max(max, r - l);
                }
                r++;
            }
            return max;
        }
    }
}
