package com.lwf.learn.everyday.data.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-03 10:12
 */
public class WordPattern {
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] s1 = s.split(" ");
            if (s1.length!=pattern.length()){
                return false;
            }
            String[] dic=new String[26];
            Map<String,Integer> map=new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                int i1 = pattern.charAt(i) - 'a';
                String s2 = s1[i];
                if (dic[i1]==null&&!map.containsKey(s2)) {
                    dic[i1]=s2;
                    map.put(s2,i1);
                }else{
                    if (dic[i1]!=null&& !dic[i1].equals(s2)) {
                        return false;
                    }
                    if (map.containsKey(s2)&&map .get(s2)!=i1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
