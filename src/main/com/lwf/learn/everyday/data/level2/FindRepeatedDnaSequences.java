package com.lwf.learn.everyday.data.level2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-04 11:11
 */
public class FindRepeatedDnaSequences {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Map<String,Integer> set=new HashMap<>();
            List<String> list=new ArrayList<>();
            for (int i = 9; i < s.length(); i++) {
                String substring = s.substring(i - 9, i + 1);
                set.put(substring,set.getOrDefault(substring,0)+1);
                if (set.get(substring)==2){
                    list.add(substring);
                }
            }
            return list;
        }
    }
}
