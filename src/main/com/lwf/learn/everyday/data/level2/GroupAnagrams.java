package com.lwf.learn.everyday.data.level2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-03 10:53
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,Integer> map=new HashMap<>();
            List<List<String>> rtn=new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key=String.valueOf(chars);
                if (map.containsKey(key)){
                    List<String> list = rtn.get(map.get(key));
                    list.add(str);
                }else{
                    List<String> list=new ArrayList<>();
                    list.add(str);
                    rtn.add(list);
                    map.put(key,rtn.size()-1);
                }
            }
            return rtn;
        }
    }
}
