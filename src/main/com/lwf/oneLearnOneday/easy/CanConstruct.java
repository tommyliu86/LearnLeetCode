package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2024/1/8 8:56
 */
public class CanConstruct {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] marks=new int[26];
            for (int i = 0; i < magazine.length(); i++) {
                marks[magazine.charAt(i)-'a']++;
            }
            for (int i = 0; i < ransomNote.length(); i++) {
                int j = ransomNote.charAt(i) - 'a';
                marks[j]--;
                if (marks[j]<0){
                    return false;
                }
            }
            return  true;
        }
    }
}
