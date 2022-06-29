package com.lwf.learn.everyday.data.level2.d2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-28 15:37
 */
public class WordPattern {
    class Solution {
        public boolean wordPattern(String pattern, String s) {

            char[] chars = pattern.toCharArray();
            String[] split = s.split(" ");
            if (chars.length!=split.length){
                return false;
            }
            Map<String,Character> s2c=new HashMap<>();
            Map<Character,String> c2s=new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                if (s2c.containsKey(split[i])&&c2s.containsKey(chars[i])&&s2c.get(split[i])==chars[i]&&c2s.get(chars[i]).equals(split[i])){
                    continue;
                } else if (!s2c.containsKey(split[i])&&!c2s.containsKey(chars[i])){
                    s2c.put(split[i],chars[i]);
                    c2s.put(chars[i],split[i]);
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
