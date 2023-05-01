package com.lwf.offer.two.tow;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/4/15 11:36
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                String s = get(str);
                List<String> list = map.getOrDefault(s, new ArrayList<String>());
                list.add(str);
                map.put(s, list);
            }
            return new ArrayList<>(map.values());
        }

        public String get(String s) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
    }
}
