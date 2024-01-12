package com.lwf.oneLearnOneday.easy;

import java.util.Queue;
import java.util.Stack;

/**
 * 2696. 删除子串后的字符串最小长度
 *
 * @author liuwenfei
 * @date 2024/1/10 8:37
 */
public class MinLength {
    /**
     * 找相邻位置是否可以移除，用栈来做肯定最简单！
     */
    class Solution {
        public int minLength(String s) {
            Stack<Character> stack=new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty()&&((stack.peek()=='A'&&s.charAt(i)=='B')||(stack.peek()=='C'&&s.charAt(i)=='D'))){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }

            }
            return stack.size();
        }
    }

    /**
     * 双指针，每个位置可以前进和后退，当移除字符之后，需要替换成不是大写字母的，这样可以知道是否被移除掉了
     */
    class Solution1 {
        public int minLength(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int removed = 0;
            while (i < s.length()) {
                if (chars[i] == 'A' || chars[i] == 'C') {
                    int j = i + 1;
                    while (j < s.length() && chars[j] == '0') {
                        j++;
                    }
                    if (j == s.length()) {
                        break;
                    }
                    if ((chars[i] == 'A' && chars[j] == 'B') || (chars[i] == 'C' && chars[j] == 'D')) {
                        chars[j++] = '0';
                        chars[i] = '0';
                        while (i >= 0 && chars[i] == '0') {
                            i--;
                        }
                        removed += 2;
                        if (i < 0) {
                            i = j;
                        }
                    } else {
                        i++;
                    }

                } else {
                    i++;
                }
            }
            return s.length() - removed;
        }
    }
}
