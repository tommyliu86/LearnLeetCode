package com.lwf.offer.two.tow;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans=new ArrayList<>();
            if (s.length()<p.length()) return ans;
            int[] chars=new int[26];
            for (int i = 0; i < p.length(); i++) {
                chars[p.charAt(i)-'a']++;
            }
            int i=0;
            while (i<p.length()-1){
                chars[s.charAt(i++)-'a']--;
            }
            while (i<s.length()){
                chars[s.charAt(i++)-'a']--;
                boolean ok=true;
                for (int j = 0; ok&&j < chars.length; j++) {
                    if (chars[j]!=0)ok=false;
                }
                if (ok){
                    ans.add(i-p.length());
                }
                chars[s.charAt(i-p.length())-'a']++;
            }
            return ans;
        }
    }
}
