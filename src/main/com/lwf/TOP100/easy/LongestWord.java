package com.lwf.TOP100.easy;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 * 720. 词典中最长的单词
 *
 * @author: liuwenfei14
 * @date: 2022-03-17 14:15
 */
public class LongestWord {
    public String longestWord(String[] words) {
        Arrays.sort(words, Comparator.comparing(s -> s.length()));
        Set<String> set = new HashSet<>();
        String longStr = "";
        set.add(longStr);
        for (String word : words) {

            String substring = word.substring(0, word.length() - 1);
            if (set.contains(substring)) {
                set.add(word);
                if (longStr.length() == word.length()) {
                    longStr = longStr.compareTo(word) > 0 ? word : longStr;
                } else if (longStr.length() < word.length()) {
                    longStr = word;
                }
            }

        }
        return longStr;
    }
}
