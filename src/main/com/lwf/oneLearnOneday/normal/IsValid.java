package com.lwf.oneLearnOneday.normal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/5/4 14:21
 */
public class IsValid {
    /**
     * 栈
     */
    class Solution {
        public boolean isValid(String s) {
            List<Character> stack = new LinkedList<>();
            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                int l = stack.size();
                if (c == 'c' && l >= 2 && stack.get(l - 1) == 'b' && stack.get(l - 2) == 'a') {
                    stack.remove(l - 1);
                    stack.remove(l - 2);
                } else {
                    stack.add(c);
                }
                i++;
            }
            return stack.isEmpty();
        }
    }

    /**
     * 直接利用字符串替换
     */
    class Solution1 {
        public boolean isValid(String s) {
            if (s.length() % 3 != 0) return false;
            while (s.contains("abc")) {
                s = s.replace("abc", "");
            }
            return s.length() == 0;
        }
    }
}
