package com.lwf.oneLearnOneday.hard;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluate {
    public static void main(String[] args) {
        new Solution().evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))");
    }

    static class Solution {
        List<Map<String, Integer>> varList = new ArrayList<>();

        public int evaluate(String expression) {
            return exper(expression.toCharArray(), 0, expression.length() - 1, 0);
        }

        public int mLet(char[] chars, List<int[]> split, int index) {
            Map<String, Integer> vars = new HashMap<>();
            if (varList.size() <= index) {
                varList.add(vars);
            } else {
                varList.set(index, vars);
            }

            for (int i = 1; i < split.size() - 1; i += 2) {
                int[] first = split.get(i);
                int[] second = split.get(i + 1);

                String var = String.valueOf(chars, first[0], first[1] - first[0] + 1);
                int value = getValue(chars, second[0], second[1], index + 1);
                vars.put(var, value);
            }
            int[] exp = split.get(split.size() - 1);

            return getValue(chars, exp[0], exp[1], index + 1);
        }

        public int getValue(char[] chars, int l, int r, int index) {
            if (chars[l] == '(') {
                return exper(chars, l, r, index);
            } else {
                return variable(chars, l, r, index);
            }
        }

        private int variable(char[] chars, int l, int r, int index) {
            String v = String.valueOf(chars, l, r - l + 1);
            for (int i = index - 1; i >= 0; i--) {
                Map<String, Integer> map = varList.get(i);
                if (map.containsKey(v)) {
                    return map.get(v);
                }
            }
            return Integer.valueOf(v);
        }

        private int exper(char[] chars, int l, int r, int index) {
            int rtn;
            List<int[]> sub = split(chars, l, r);
            int[] ints = sub.get(0);
            String key = String.valueOf(chars, ints[0], ints[1] - ints[0] + 1);
            if (key.equals("let")) {
                rtn = mLet(chars, sub, index);
            } else if (key.equals("add")) {
                rtn = mAdd(chars, sub, index);
            } else {
                rtn = mMulti(chars, sub, index);
            }
            return rtn;
        }

        private List<int[]> split(char[] chars, int l, int r) {
            List<int[]> rtn = new ArrayList<>();
            for (int i = l + 1; i < r; i++) {
                if (chars[i] == '(') {
                    int count = 1;
                    int j = i + 1;
                    while (count != 0) {
                        while (chars[j] != '(' && chars[j] != ')') {
                            j++;
                        }
                        if (chars[j] == '(') {
                            count++;
                        } else {
                            count--;
                        }
                        j++;
                    }
                    rtn.add(new int[]{i, j - 1});
                    i = j;

                } else {
                    int j = i;
                    while (j < r && chars[j] != ' ') {
                        j++;
                    }
                    rtn.add(new int[]{i, j - 1});
                    i = j;
                }
            }
            return rtn;
        }

        public int mAdd(char[] chars, List<int[]> list, int index) {
            int[] first = list.get(1);
            int f = getValue(chars, first[0], first[1], index);
            int[] second = list.get(2);
            int s = getValue(chars, second[0], second[1], index);
            return f + s;
        }

        public int mMulti(char[] chars, List<int[]> list, int index) {
            int[] first = list.get(1);
            int f = getValue(chars, first[0], first[1], index);
            int[] second = list.get(2);
            int s = getValue(chars, second[0], second[1], index);
            return f * s;
        }
    }
}
