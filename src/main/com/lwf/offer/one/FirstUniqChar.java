package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/1/16 16:54
 */
public class FirstUniqChar {
    class Solution {
        public char firstUniqChar(String s) {
            int[] counts=new int[26];
            int[] indexs=new int[26];
            for (int i = 0; i < s.length(); i++) {
                int i1 = s.charAt(i) - 'a';
                counts[i1]++;
                if (indexs[i1]==0) {
                    indexs[i1]=i+1;
                }
            }
            int min=s.length()+1;
            char ans=' ';
            for (int i = 0; i < counts.length; i++) {
                if (counts[i]==1){
                    if (min>indexs[i]) {
                        min=indexs[i];
                        ans=(char) (i+'a');
                    }
                }
            }
            return ans;
        }
    }
}
