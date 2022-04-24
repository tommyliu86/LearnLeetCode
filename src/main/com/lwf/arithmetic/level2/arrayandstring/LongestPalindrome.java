package com.lwf.arithmetic.level2.arrayandstring;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-24 16:22
 */
public class LongestPalindrome {
    /**
     * 双循环
     */
    class test {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int max=1;
            int left=0;
            int right=0;
            for (int i = 0; i+max < chars.length; i++) {
                char aChar = chars[i];
                for (int j = i+1; j < chars.length; j++) {
                    if (j-i+1>max&&aChar==chars[j]&& isPa(chars,i,j)){
                        max=j-i+1;
                        left=i;
                        right=j;
                    }
                }
            }
            return s.substring(left,right+1);
        }
        public boolean isPa(char[] chars, int left, int right) {
            while (left < right) {
                if (chars[left] != chars[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
    /**
     * hash保存 每个char的出现的index。
     */
    class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            Map<Character, List<Integer>> map = new HashMap<>();
            int max = 1;
            int[] maxes = new int[2];
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (map.containsKey(aChar)) {
                    List<Integer> list = map.get(aChar);
                    for (Integer integer : list) {
                        if (i - integer + 1 > max && isPa(chars, integer, i)) {
                            if (i - integer + 1 > max) {
                                max = i - integer + 1;
                                maxes[0] = integer;
                                maxes[1] = i;
                            }
                        }
                    }
                    list.add(i);
                } else {
                    map.put(aChar, new ArrayList<Integer>(Arrays.asList(i)));
                }
            }
            return s.substring(maxes[0], maxes[1]);
        }

        public boolean isPa(char[] chars, int left, int right) {
            while (left < right) {
                if (chars[left] != chars[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
