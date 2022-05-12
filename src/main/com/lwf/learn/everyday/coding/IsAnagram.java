package com.lwf.learn.everyday.coding;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-12 10:58
 */
public class IsAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length()!=t.length()){
                return false;
            }
            int[] sums=new int[26];
            for (int i = 0; i < s.length(); i++) {
                int j= s.charAt(i)-'a';
                sums[j]++;
            }
            for (int i = 0; i < t.length(); i++) {
                int j= t.charAt(i)-'a';
                sums[j]--;
                if (sums[j]<0){
                    return false;
                }
            }
            return true;
        }
    }
}
