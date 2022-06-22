package com.lwf.learn.everyday.data.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-14 10:01
 */
public class FrequencySort {

    class Solution {
        public String frequencySort(String s) {
            Map<Character,Integer> map=new HashMap<>();
            char[] chars1 = s.toCharArray();
            for (int i = 0; i < chars1.length; i++) {
                map.put(chars1[i],map.getOrDefault(chars1[i],0)+1);
            }
            StringBuilder[] chars=new StringBuilder[s.length()+1];

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (chars[entry.getValue()]==null) {
                    chars[entry.getValue()]=new StringBuilder();
                }
                chars[entry.getValue()].append(entry.getKey());
            }
            StringBuilder builder = new StringBuilder();

            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i]!=null){
                    for (int i1 = 0; i1 < chars[i].length(); i1++) {
                        char c = chars[i].charAt(i1);
                        for (int j = 0; j < i; j++) {
                            builder.append(c);
                        }
                    }
                }
            }
            return builder.toString();
        }
    }
}
