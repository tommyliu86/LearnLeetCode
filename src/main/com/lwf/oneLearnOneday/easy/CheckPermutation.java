package com.lwf.oneLearnOneday.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2022/9/27 8:50
 */
public class CheckPermutation {
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length()!=s2.length()){
                return false;
            }
            Map<Character,Integer> map=new HashMap<>();
            for (char c : s1.toCharArray()) {
                map.put(c,map.getOrDefault(c,0)+1);
            }
            for (char c : s2.toCharArray()) {
                if (!map.containsKey(c)) {
                    return false;
                }
                int cur = map.get(c) - 1;
                if (cur==0){
                    map.remove(c);
                }else{
                    map.put(c,cur);
                }
            }
            return map.size()==0;
        }
    }
}
