package com.lwf.offer.two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/3/3 10:14
 */
public class FindAnagrams {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans=new ArrayList<>();
            if (s.length()<p.length()) return ans;
            int[] count=new int[26];
            for (int i = 0; i < p.length(); i++) {
                count[p.charAt(i)-'a']++;
            }
            int i=0,j=0;
            while (j<p.length()-1){
                count[s.charAt(j++)-'a']--;
            }
            while (j<s.length()){
                count[s.charAt(j++)-'a']--;
                if (check(count)){
                    ans.add(i);
                }
                count[s.charAt(i++)-'a']++;
            }
            return ans;
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
