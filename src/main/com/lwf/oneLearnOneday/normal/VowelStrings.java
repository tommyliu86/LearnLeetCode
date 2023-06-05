package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/6/2 9:11
 */
public class VowelStrings {
    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            //构建一个字符集包含元音字母a, e, i, o, u
            Set<Character> sets = new HashSet<>();
            sets.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

            //单词数组长度
            int l = words.length;

            //记录每个单词是否以元音字母开头和结尾,wordl[i]=1表示是,否则为0
            int[] wordl = new int[l];

            //遍历单词数组
            for (int i = 0; i < words.length; i++) {

                //如果单词首尾字母都在元音字母集合中
                if (sets.contains(words[i].charAt(0)) && sets.contains(words[i].charAt(words[i].length() - 1))) {
                    wordl[i] = 1;
                }
            }

            //前缀和数组,sums[i]表示前i个单词中以元音字母开头和结尾的单词数之和
            int[] sums = new int[l + 1];

            //计算前缀和
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + wordl[i - 1];
            }

            //结果数组
            int[] ans = new int[queries.length];

            //遍历查询数组
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];

                //查询区间的answers个数为sums[右区间+1] - sums[左区间]
                ans[i] = sums[query[1] + 1] - sums[query[0]];
            }
            return ans;

        }
    }
}
