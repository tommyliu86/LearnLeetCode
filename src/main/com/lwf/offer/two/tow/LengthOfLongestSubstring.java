package com.lwf.offer.two.tow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    class Solution {
        /**
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            if (s.length() < 2) return s.length();
            Map<Character, Integer> map = new HashMap<>();
            int left = -1;
            int ans = 1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    left = Math.max(left, map.get(c));
                }
                ans = Math.max(ans, i - left);

                map.put(c, i);
            }
            return ans;
        }
    }
}
