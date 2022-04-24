package com.lwf.arithmetic.level2.arrayandstring;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-24 14:55
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> map=new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                if (map.containsKey(key)){
                    map.get(key).add(strs[i]);
                }else{
                    map.put(key,new ArrayList<String>(Arrays.asList( strs[i])));
                }
            }
          return new ArrayList<>(  map.values());
        }
    }
}
