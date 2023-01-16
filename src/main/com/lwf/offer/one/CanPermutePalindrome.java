package com.lwf.offer.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/1/16 17:17
 */
public class CanPermutePalindrome {
    class Solution {
        public boolean canPermutePalindrome(String s) {
            char[] chars = s.toCharArray();
            Map<Character,Integer> map=new HashMap<>();
            for (int i   = 0; i < chars.length; i++) {
                map.put(chars[i],map.getOrDefault(chars[i],0)+1);
            }
            int c=0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                c+=entry.getValue()%2;
            }
            return c<2;
        }
    }
}
