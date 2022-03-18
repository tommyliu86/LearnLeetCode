package com.lwf.TOP100.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 32.最长有效括号
 *
 * @author: liuwenfei14
 * @date: 2022-02-21 19:24
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();

        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);//如果栈中只放匹配的，会出现()()这种字符串没法做累加计算，因此需要保留一个不匹配的开始位来作为起点
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {

            char aChar = chars[i];
            if (aChar == '(') {
                stack.push(i);
            } else {
                stack.pop();//弹出栈顶，如果栈空了表示把不匹配的最左坐标弹出了，这个串没符合，就把当前坐标放进去作为最左
                if (stack.isEmpty()) {
                    stack.push(i);
                } else { //否则弹出一个后，栈还没空，表示当前串是有效串


                    maxLength = Math.max(maxLength, i - stack.peek());


                }
            }
        }
        return  maxLength ;
    }
}
