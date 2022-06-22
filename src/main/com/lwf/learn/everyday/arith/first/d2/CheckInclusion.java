package com.lwf.learn.everyday.arith.first.d2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-18 15:10
 */
public class CheckInclusion {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length()>s2.length()){
                return false;
            }
            int[] chars1=new int[26];
            char[] chars = s1.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars1[chars[i]-'a']++;
            }
            int[] chars2=new int[26];
           char[] charss=s2.toCharArray();
           int l=0;
           int r=0;
           while (r<s2.length()){
               while (r-l<s1.length()){
                   chars2[charss[ r]-'a']++;
                   r++;
               }
               if (Arrays.equals( chars1,chars2)){
                   return true;
               }
               chars2[charss[r++]-'a']++;
               chars2[charss[l++]-'a']--;
           }
           return false;
        }
    }
}
