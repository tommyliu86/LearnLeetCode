package com.lwf.learn.everyday.th75;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length()!=t.length()){
                return false;
            }
            Map<Character,Character> s2t=new HashMap<>();
            Map<Character,Character> t2s=new HashMap<>();
            char[] charA = s.toCharArray();
            char[] charB = t.toCharArray();

            for (int i = 0; i < charA.length; i++) {
                char a = charA[i];
                char b = charB[i];
                if (!s2t.containsKey(a)&&!t2s.containsKey(b)){
                    s2t.put(a,b);
                    t2s.put(b,a);
                } else{
                    Character b1 = s2t.get(a);
                    Character a1 = s2t.get(b);
                    if (b1==null||a1==null|| a!=a1||b!=b1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
