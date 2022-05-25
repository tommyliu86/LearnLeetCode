package com.lwf.learn.everyday.arith.second.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-23 16:46
 */
public class GenerateParenthesis {
    class Solution {
        public List<String> generateParenthesis(int n) {
            int left = n;
            int right = n;
            char[] dynamic = new char[2 * n];
            List<String> rtn = new ArrayList<>();
            recursive(left, right, dynamic, 0, rtn);
            return rtn;

        }

        public void recursive(int left, int right, char[] dynamic, int index, List<String> rtn) {
            if (index == dynamic.length) {
                if (dynamic.length > 0) {
                    rtn.add(String.valueOf(dynamic));
                }
                return;
            }
            if (left == right) {
                dynamic[index] = '(';
                recursive(left - 1, right, dynamic, index + 1, rtn);
            } else if (left > right) {
                return;
            } else {
                if (left > 0) {
                    dynamic[index] = '(';
                    recursive(left - 1, right, dynamic, index + 1, rtn);
                }
                dynamic[index] = ')';
                recursive(left, right - 1, dynamic, index + 1, rtn);
            }
        }
    }
}
