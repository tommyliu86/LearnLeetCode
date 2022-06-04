package com.lwf.learn.everyday.dp.level1.d2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 13:35
 */
public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Map<Character,List<String>> map=new HashMap<>();
            for (String s1 : wordDict) {
                char c = s1.charAt(s1.length() - 1);
                List<String> list = map.getOrDefault(c, new ArrayList<>());
                list.add(s1);
                map.put(c,list);
            }
            boolean[] marks=new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)){
                    List<String> list = map.get(c);
                    for (int j = 0; j < list.size(); j++) {
                        String s1 = list.get(j);
                        if (i+1>=s1.length()&&(i-s1.length()==-1|| marks[i-s1.length()]) &&equal(s,i,s1)) {
                            marks[i]=true;
                            break;
                        }
                    }
                }
            }
            return marks[s.length()-1];
        }
        public boolean equal(String s,int right,String t){
            for (int l = t.length()-1; l >= 0; l--,right--) {
                if (t.charAt(l)!=s.charAt(right)){
                    return false;
                }
            }
            return true;
        }
    }
}
