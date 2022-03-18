package com.lwf.TOP100.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * author Administrator
 * time 2019-09-25-22:44
 * {@link 17.md}
 */
public class LetterCombinations {
    private String[] strings = new String[]{"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> lists = new ArrayList<>();
        if (digits==null||digits.length()==0) return lists;
        char[] chars = digits.toCharArray();

        char[] gets = new char[chars.length];
        backTracking(chars, gets, 0, lists);
        return lists;
    }

    void backTracking(char[] res, char[] gets, int i, List<String> lists) {
        if (i >= res.length) {
            lists.add(String.valueOf(gets, 0, i));
            return;
        }
        String resStr = strings[res[i]-'0'];
        for (char c : resStr.toCharArray()) {
            gets[i] = c; //每个for循环设置不同的值，i值在一个栈中是不变的。因此做到了回溯覆盖的作用。
            backTracking(res, gets, i + 1, lists);

        }
    }
}
