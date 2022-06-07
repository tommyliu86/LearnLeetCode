package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-07 11:13
 */
public class MinRemoveToMakeValid {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            char[] chars = s.toCharArray();
            Stack<Integer> stack=new Stack<>();
            List<Integer> needremove=new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]=='('){
                    stack.push(i);
                }else if (chars[i]==')'){
                    if (stack.isEmpty()){
                        needremove.add(i);
                    }else{
                        stack.pop();
                    }
                }
            }
            while (!stack.isEmpty()){
                needremove.add(stack.pop());
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (needremove.contains(i)){
                    continue;
                }
                builder.append(chars[i]);
            }
            return builder.toString();
        }
    }
}
