package com.lwf.arithmetic.level2.other;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-18 16:31
 */
public class EvalRPN {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack=new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                String c = tokens[i];
                if (c.equals("+")){
                    stack.push(stack.pop()+stack.pop());
                }else if (c.equals("-")){
                    stack.push(stack.pop()*-1+stack.pop());
                }else if (c.equals("*")){
                    stack.push(stack.pop()*stack.pop());
                }else if (c.equals("/")){
                    Integer p2 = stack.pop();
                    Integer p1 = stack.pop();
                    stack.push(p1/p2);
                }else {
                    stack.push(Integer.valueOf(c));
                }
            }
            return stack.pop();
        }
    }
}
