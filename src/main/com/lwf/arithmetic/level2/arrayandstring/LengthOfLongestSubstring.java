package com.lwf.arithmetic.level2.arrayandstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-24 15:46
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println((int) Character.MAX_VALUE);
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int pre = 0;
            int i = 0;
            int max=0;
            Map<Character, Integer> indexMap = new HashMap<>();

            while (i < chars.length) {
                if (indexMap.containsKey(chars[i])) {
                    Integer index = indexMap.get(chars[i]);
                    if (pre <= index) {
                        pre = index + 1;
                    }
                }
                max=Math.max(max,i-pre+1);
                indexMap.put(chars[i], i);
                i++;
            }
            return Math.max( max, i-pre);
        }
    }
}
