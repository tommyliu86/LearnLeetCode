package com.lwf;

import java.util.Arrays;
import java.util.HashMap;

/**
 * author Administrator
 * time 2019-07-30
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        char[] tt = t.toCharArray();
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);
    }

    public boolean isAnagram1(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            for (char c : t.toCharArray()) {
                if (!map.containsKey(c)) {
                    return false;
                } else {
                    if (map.get(c)==1) {
                        map.remove(c);
                    }else{
                        map.put(c,map.get(c)-1);
                    }
                }
            }
            return map.isEmpty();
    }
}
