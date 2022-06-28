package com.lwf.learn.everyday.coding.level2.d2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-23 17:51
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> map=new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];

                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key=String.valueOf(chars);

                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key,list);
            }
            List<List<String>> rtn=new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                rtn.add(entry.getValue());
            }
            return rtn;
        }
    }
}
