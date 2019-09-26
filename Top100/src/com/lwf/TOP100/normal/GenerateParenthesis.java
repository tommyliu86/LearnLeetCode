package com.lwf.TOP100.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * author Administrator
 * time 2019-09-26-22:45
 * {@link 22.md}
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        char[] chars = new char[2 * n];
        ArrayList<String> lists = new ArrayList<>();
        backtracking(chars, 0, left, right, lists);
        return lists;
    }

    void backtracking(char[] chars, int current, int left, int right, List<String> lists) {
        if (current >= chars.length) {
            lists.add(String.valueOf(chars));
        } else {
            if (left < right && left > 0) {
                left--;
                chars[current++] = '(';
                backtracking(chars, current, left, right, lists);
                left++;
                right--;
                chars[current - 1] = ')';
                backtracking(chars, current, left, right, lists);

            } else if (left == right) {
                left--;
                chars[current++] = '(';
                backtracking(chars, current, left, right, lists);
            } else if (left == 0) {
                right--;
                chars[current++] = ')';
                backtracking(chars, current, left, right, lists);

            }
        }
    }
}
