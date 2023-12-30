package com.lwf.classic.one;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/1/12 19:23
 */
public class CheckPermutation {
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
           int[] counts=new int[26];
            for (int i = 0; i < s1.length(); i++) {
                int i1 = s1.charAt(i) - 'a';
                counts[i1]++;
            }
            for (int i = 0; i < s2.length(); i++) {
                int i1 = s2.charAt(i) - 'a';
                counts[i1]--;
                if (counts[i1]<0){
                    return false;
                }
            }
            int sum=0;
            for (int count : counts) {
                sum+=count;
            }
            return sum==0;
        }
    }
    class Solution1 {
        public boolean CheckPermutation(String s1, String s2) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);

            return Arrays.equals(chars1,chars2);
        }
    }
}
