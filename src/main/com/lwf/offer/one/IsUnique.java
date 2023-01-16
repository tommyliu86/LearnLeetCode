package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/1/12 19:18
 */
public class IsUnique {
    class Solution {
        public boolean isUnique(String astr) {
            int[] counts=new int[26];
            for (int i = 0; i < astr.length(); i++) {
                int i1 = astr.charAt(i) - 'a';
                counts[i1]++;
                if (counts[i1]>1){
                    return false;
                }
            }
            return true;
        }
    }
}
