package com.lwf.offer.two.tow;

public class CheckInclusion {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length()>s2.length()) return false;
            int[] chars=new int[26];
            for (int i = 0; i < s1.length(); i++) {
                chars[s1.charAt(i)-'a']++;
            }
            int i=0,j=0;
            while (j<s1.length()-1){
                chars[s2.charAt(j++)-'a']--;
            }
            while (j<s2.length()){
                chars[s2.charAt(j++)-'a']--;
                boolean ok=true;
                for (int k = 0;ok&& k < chars.length; k++) {
                    if (chars[k]!=0){
                        ok=false;
                    }
                }
                if (ok){
                    return true;
                }
                chars[s2.charAt(j-s1.length())-'a']++;
            }
            return false;
        }
    }
}
