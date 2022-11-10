package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2022/11/8 9:01
 */
public class CountConsistentStrings {
    /**
     * 遍历，速度81%
     */
    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            int[] keys=new int[26];
            for (int i = 0; i < allowed.length(); i++) {
               keys[ allowed.charAt(i)-'a']=1;
            }
            int count=0;
            for (String word : words) {
                char[] chars = word.toCharArray();
                boolean ok=true;
                for (char aChar : chars) {
                    if (keys[aChar-'a']==0) {
                        ok=false;
                        break;
                    }
                }
                count+=(ok?1:0);
            }
            return count;
        }
    }
    /**
     * stream 速度 5%
     */
    class Solution1 {
        public int countConsistentStrings(String allowed, String[] words) {
            Set<Integer> keys=new HashSet<>();
            allowed.chars().forEach(i->keys.add(i));

            long count = Arrays.stream(words).filter(w -> {
                if (w.chars().anyMatch(i -> !keys.contains(i))) {
                    return false;
                } else {
                    return true;
                }
            }).count();
            return (int) count;
        }
    }
}
