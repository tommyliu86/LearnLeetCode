package com.lwf.classic.two.tow;

/**
 * @author liuwenfei
 * @date 2023/3/31 9:21
 */
public class MaxProduct {
    /**
     * 位运算，使用位来表示字母
     */
    class Solution {
        public int maxProduct(String[] words) {
            int[] marks=new int[words.length];
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                   marks[i]|= word.charAt(j)-'a';
                }
            }
            int ans=0;
            for (int i = 0; i < marks.length; i++) {
                for (int j = i+1; j < marks.length; j++) {
                    if (marks[i]%marks[j]==0){
                        ans=Math.max(ans,words[i].length()*words[j].length());
                    }
                }
            }
            return ans;
        }
    }
}
