package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/3/1 19:02
 */
public class MaxProduct {
    class Solution {
        public int maxProduct(String[] words) {
            int max=0;
            for (int i = 0; i < words.length; i++) {
                int first = deal( words[i]);
                for (int j = i+1; j < words.length; j++) {
                    int second =  deal(words[j]);
                    if ((first&second)==0){
                        max=Math.max(max,words[i].length()*words[j].length());
                    }
                }
            }
            return max;
        }
        public int deal(String str){
            int ans=0;
            for (int i = 0; i < str.length(); i++) {
                int i1 = str.charAt(i) - 'a';
                ans|=1<<i1;
            }
            return ans;
        }
    }
}
