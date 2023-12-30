package com.lwf.classic.two;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/3/17 18:02
 */
public class EvalRPN {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Long> stack=new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                String token = tokens[i];
                if (token.equals("+")){
                    Long sec = stack.pop();
                    Long first = stack.pop();
                    stack.push(sec+first);
                }else if (token.equals("-")){
                    Long sec = stack.pop();
                    Long first = stack.pop();
                    stack.push(first-sec);
                }else if (token.equals("*")){
                    Long sec = stack.pop();
                    Long first = stack.pop();
                    stack.push(sec*first);
                }else if (token.equals("/")){
                    Long sec = stack.pop();
                    Long first = stack.pop();
                    stack.push(first/sec);
                }else{
                    stack.push(Long.valueOf(token));
                }
            }
            return stack.pop().intValue();
        }
    }
}
