package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 318. 最大单词长度乘积
 * https://leetcode.cn/problems/maximum-product-of-word-lengths/?envType=daily-question&envId=2023-10-30
 * @author liuwenfei
 * @date 2023/11/6 8:37
 */
public class MaxProduct318 {
    /**
     * 位运算
     * 双重for循环，进行暴力循环计算，唯一的技巧点 是使用位运算 记录单词中的字母是否存在，进行O（1）的计算
     */
    class Solution {
        public int maxProduct(String[] words) {
            Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
            int[] lens=new int[words.length];
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                    lens[i]|=1<<(word.charAt(j)-'a');
                }
            }
            int ans=0;
            for (int i = words.length-1; i >= 0&&i*(i-1)>ans; i--) {
                for (int j = i-1; j >= 0; j--) {
                    if ((lens[i]&lens[j])==0){
                        ans=Math.max(ans,words[i].length()*words[j].length());
                    }
                }
            }
            return ans;
        }
    }
}
