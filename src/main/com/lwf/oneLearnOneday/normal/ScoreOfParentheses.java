package com.lwf.oneLearnOneday.normal;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2022/10/9 11:01
 */
public class ScoreOfParentheses {
    class Solution {
        public int scoreOfParentheses(String s) {
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            Stack<Integer> sum = new Stack<>();
            int i = 0;
            while (i < chars.length) {
                if (chars[i] == '(') {
                    stack.add(chars[i]);
                } else {
                    int sub = 0;
                    while (!stack.isEmpty() && stack.peek() == '|') {
                        stack.pop();
                        sub += sum.pop();
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }

                    if (sub == 0) {
                        sum.add(1);
                    } else {
                        sum.add(2 * sub);
                    }
                    stack.add('|');
                }
                i++;
            }
            int ans = 0;
            while (!sum.isEmpty()) {
                ans += sum.pop();
            }
            return ans;
        }
    }
}
