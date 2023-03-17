package com.lwf.offer.two;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/3/17 17:14
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> map=new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                String key = getKey(str);
                List<String> list = map.getOrDefault(key, new ArrayList<String>());
                boolean add = list.add(strs[i]);
                map.put(key,list);
            }
            return new ArrayList<>( map.values());
        }
        public String getKey(String s){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
    }
}
