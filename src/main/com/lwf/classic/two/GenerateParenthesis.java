package com.lwf.classic.two;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    /**
     * 思路核心是考虑每个位置能够放什么，
     */
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            recurse(n, n, stringBuilder, ans);
            return ans;
        }

        public void recurse(int l, int r, StringBuilder sb, List<String> ans) {
            if (l == 0 && r == 0) {
                ans.add(sb.toString());
                return;
            }
            if (l > 0) {
                sb.append('(');
                recurse(l - 1, r, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (l < r) {
                sb.append(')');
                recurse(l, r - 1, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
