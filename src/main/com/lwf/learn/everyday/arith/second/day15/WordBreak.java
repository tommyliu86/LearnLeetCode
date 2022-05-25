package com.lwf.learn.everyday.arith.second.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-27 15:56
 */
public class WordBreak {
    public static void main(String[] args) {
        new dp().wordBreak(
                "leetcode"
                       , Arrays.asList("leet","code"));
    }
    /**
     * 动态规划，dp， 状态转移方程 注意边界条件处理！
     */
    static class dp {
        public boolean wordBreak(String s, List<String> wordDict) {
            List<String>[] dics = new List[26];

            for (int i = 0; i < dics.length; i++) {
                dics[i] = new ArrayList<>();
            }
            for (int i = 0; i < wordDict.size(); i++) {
                String s1 = wordDict.get(i);
                int j = s1.charAt(s1.length() - 1) - 'a';
                dics[j].add(s1);
            }

            char[] chars = s.toCharArray();
            boolean[] mark = new boolean[chars.length];

            for (int i = 0; i < chars.length; i++) {
                int i1 = chars[i] - 'a';
                if (dics[i1].size() > 0) {
                    List<String> dic = dics[i1];
                    for (String s1 : dic) {

                        if (isOk(chars, i, s1) ) {
                            if (i+1 - s1.length()==0||mark[i-s1.length()]){
                                mark[i] = true;
                                break;
                            }

                        }
                    }
                }

            }
            return mark[mark.length - 1];

        }

        public boolean isOk(char[] chars, int right, String s) {
            char[] ss = s.toCharArray();
            for (int i = ss.length - 1; i >= 0; i--, right--) {
                if (right < 0) {
                    return false;
                }
                if (ss[i] != chars[right]) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 从前向后，递归遍历法，超时
     */
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            char[] chars = s.toCharArray();
            List<String>[] dics = new List[26];
            for (int i = 0; i < dics.length; i++) {
                dics[i] = new ArrayList<>();
            }
            for (String s1 : wordDict) {
                int i = s1.charAt(0) - 'a';
                List<String> dic = dics[i];
                dic.add(s1);
            }
            return recursive(chars, 0, dics);
        }

        public boolean recursive(char[] chars, int index, List<String>[] map) {
            if (index == chars.length) {
                return true;
            }
            char aChar = chars[index];
            List<String> dic = map[aChar - 'a'];
            if (dic.isEmpty()) {
                return false;
            }
            for (int i = 0; i < dic.size(); i++) {
                String s = dic.get(i);
                if (isOk(chars, index, s) && recursive(chars, index + s.length(), map)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isOk(char[] chars, int left, String s) {
            char[] chars1 = s.toCharArray();
            for (int i = 0; i < chars1.length; i++, left++) {
                if (left >= chars.length) {
                    return false;
                }
                if (chars[left] != chars1[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
