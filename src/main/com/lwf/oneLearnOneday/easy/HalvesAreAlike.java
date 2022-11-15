package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2022/11/11 9:08
 */
public class HalvesAreAlike {
    class Solution {
        public boolean halvesAreAlike(String s) {
            int n = s.length();
            int count = 0;
            Set<Character> set = new HashSet<>();
            set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            for (int i = 0; i < n / 2; i++) {
                if (set.contains(s.charAt(i))) {
                    count++;
                }
            }
            for (int i = n / 2; i < n; i++) {
                if (set.contains(s.charAt(i))) {
                    count--;
                }
                if (count < 0) {
                    return false;
                }
            }
            return true;

        }
    }
}

