package com.lwf.oneLearnOneday.hard;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-02 10:10
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
    }

    static class Solution {
        public boolean isValid(String code) {

            while (i < code.length()) {
                if (code.charAt(i) == '<') {
                    i++;
                    if (i >= code.length()) {
                        return false;
                    }
                    char c = code.charAt(i);
                    if (c == '!') {
                        if (!getCDATA(code)) {
                            return false;
                        }
                    } else if (c == '/') {

                        if (!getTagEnd(code)) {
                            return false;
                        }
                    } else {
                        if (i != 1 && stack.isEmpty()) {
                            return false;
                        }
                        if (!getTagStart(code)) {
                            return false;
                        }
                    }
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    i++;
                }
            }
            return stack.isEmpty();
        }

        Stack<String> stack = new Stack<>();
        int i = 0;
        String CDATA = "![CDATA[";
        String CDATAE = "]]>";

        public boolean getTagStart(String code) {
            int end = 0;
            while (i < code.length() && code.charAt(i) != '>') {
                if (code.charAt(i) <= 'Z' && code.charAt(i) >= 'A') {
                    i++;
                    end++;
                } else {
                    return false;
                }
            }
            if (end < 1 || end > 9 || i == code.length()) {
                return false;
            }
            stack.push(code.substring(i - end, i));
            i++;
            return true;
        }

        public boolean getTagEnd(String code) {
            i++;
            int end = 0;
            while (i < code.length() && code.charAt(i) != '>') {
                if (code.charAt(i) <= 'Z' && code.charAt(i) >= 'A') {
                    i++;
                    end++;
                } else {
                    return false;
                }
            }
            if (end < 1 || end > 9 || i == code.length()) {
                return false;
            }
            String substring = code.substring(i - end, i);
            if (!stack.isEmpty() && stack.peek().equals(substring)) {
                stack.pop();
                i++;
                return true;
            } else {
                return false;
            }
        }

        public boolean getCDATA(String code) {
            if (stack.isEmpty()) {
                return false;
            }
            if (i + 8 > code.length() || !CDATA.equals(code.substring(i, i + 8))) {
                return false;
            } else {
                i += 8;
            }
            while (i < code.length() - 2 && !code.substring(i, i + 3).equals(CDATAE)) {
                i++;
            }
            if (i + 3 > code.length()) {
                return false;
            } else {
                i += 3;
                return true;
            }
        }
    }
}
