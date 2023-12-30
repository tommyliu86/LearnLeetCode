package com.lwf.classic.two;

/**
 * @author liuwenfei
 * @date 2023/3/3 9:42
 */
public class CheckInclusion {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length()>s2.length()) return false;
            int[] count=new int[26];

            for (int i = 0; i < s1.length(); i++) {
                int i1 = s1.charAt(i) - 'a';
                count[i1]++;

            }
            int i=0,j=0;
            while (j<s1.length()-1){
                count[s2.charAt(j++)-'a']--;
            }
            while (j<s2.length()){
                count[s2.charAt(j++)-'a']--;
                if (check(count)){
                    return true;
                }
                count[s2.charAt(i++)-'a']++;
            }
            return false;
        }
        public boolean check(int[] count){
            for (int i = 0; i < count.length; i++) {
                if (count[i]!=0) {
                    return false;
                }
            }
            return true;
        }
    }
}
