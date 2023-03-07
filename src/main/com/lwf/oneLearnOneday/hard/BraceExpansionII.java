package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/3/7 9:05
 */
public class BraceExpansionII {
    /**
     * 此类问题最好不要用递归，递归思路需要考虑与前面的结合是+还是并，
     * 常规思路是考虑模拟计算栈的方法，使用两个栈，一个保存前面的数字，一个保存计算符号，
     */
    class Solution {

        public List<String> braceExpansionII(String expression) {
            Stack<Character> mark = new Stack<>();
            Stack<Set<String>> indexs = new Stack<>();
            int i = 0;
            //乘号优先于+号，因此要先乘再加
            while (i < expression.length()) {
                if (expression.charAt(i) == ',') {
                    while (!mark.isEmpty() && mark.peek() == '*') {
                        merge(indexs, mark.pop());
                    }
                    mark.push('+');
                } else if (expression.charAt(i) == '{') {
                    if (i != 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))) {
                        mark.push('*');
                    }
                    mark.push('{');
                } else if (expression.charAt(i) == '}') {
                    while (!mark.isEmpty() && mark.peek() != '{') {
                        merge(indexs, mark.pop());
                    }
                    mark.pop();
                } else {
//                    if (i!=0&&(expression.charAt(i-1)=='}'||Character.isLetter( expression.charAt(i-1)))){
                    if (i != 0 && expression.charAt(i - 1) == '}') {
                        mark.push('*');
                    }
                    int j=i+1;
                    while (j < expression.length() && Character.isLetter(expression.charAt(j))) {
                     j++;
                    }
                    Set<String> s=new TreeSet<>();
                    s.add(expression.substring(i,j));
                    indexs.add(s);
                    i=j-1;
                }
                i++;
            }
            while (!mark.isEmpty()){
                merge(indexs, mark.pop());
            }
            return new ArrayList<>( indexs.pop());
        }

        public Set<String> merge(Stack<Set<String>> in, char c) {
            Set<String> first = in.pop();
            Set<String> sec = in.pop();
            Set<String> ans = new TreeSet<>();
            if (c == '*') {
                for (String a : sec) {
                    for (String b : first) {
                        ans.add(a + b);
                    }
                }

            }
            if (c == '+') {
                ans.addAll(first);
                ans.addAll(sec);
            }
            in.push(ans);
            return ans;
        }
    }

    /**
     * 内层处理，然后使用逗号分隔出来的sub 和前缀+sub+后缀组成新的字符串进行处理，直到不存在大括号时！ylb神思路
     */
    class Solution1 {
        TreeSet<String> list = new TreeSet<>();

        public List<String> braceExpansionII(String expression) {
            dfs(expression);
            return new ArrayList<>(list);
        }

        public void dfs(String ex) {
            if (!ex.contains("}")) {
                list.add(ex);
                return;
            }
            int r = ex.indexOf('}');
            int l = r;
            while (ex.charAt(l) != '{') l--;
            String a = ex.substring(0, l);
            String c = ex.substring(r + 1);
            for (String b : ex.substring(l + 1, r).split(",")) {
                dfs(a + b + c);
            }
        }
    }
}
