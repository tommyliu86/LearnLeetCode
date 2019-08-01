package com.lwf;

import java.util.HashMap;
import java.util.Map;

/**
 * author Administrator
 * time 2019-08-01
 */
public class WordPattern {
    public static void main(String[] args) {

        System.out.println("a".equals("a"));
        System.out.println(wordPattern("abba",
                "dog cat cat dog"));
    }
    public static boolean wordPattern(String pattern, String str) {
        char[] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (patterns.length != strs.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            if (map.containsKey(patterns[i])) {
                if (!map.get(patterns[i]).equals(strs[i])) {
                    return false;
                } else {
                    continue;
                }
            }else{
                if (map.containsValue(strs[i])){
                    return false;
                }else{

                    map.put(patterns[i],strs[i]);
                }
            }
        }
        return true;
    }
}
