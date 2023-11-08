package com.lwf.oneLearnOneday.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2586. 统计范围内的元音字符串数
 * https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/description/?envType=daily-question&envId=2023-11-07
 * @author liuwenfei
 * @date 2023/11/7 8:51
 */
public class VowelStrings {
    /**
     * 直接遍历，没有技巧点
     */
    class Solution {

        public int vowelStrings(String[] words, int left, int right) {
            Set<Character> set=new HashSet<>(){
                {
                    add('a');
                    add('e');
                    add('i');
                    add('o');
                    add('u');
                }
            };
            int ans=0;
            for (int i = left; i <=right; i++) {
                String word = words[i];
                if (set.contains(word.charAt(0))&&set.contains(word.charAt(word.length()-1)))
                    ans++;
            }
            return ans;
        }
    }
}
