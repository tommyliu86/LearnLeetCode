package com.lwf.learn.everyday.coding.level2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-15 19:01
 */
public class EvalRPN {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack=new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                String str = tokens[i];
                if (str.equals("+")){
                    stack.push(stack.pop()+stack.pop());
                }else if (str.equals("-")){
                    Integer pop1 = stack.pop();
                    Integer pop2 = stack.pop();
                    stack.push(pop2-pop1);
                }else if (str.equals("*")){
                    stack.push(stack.pop()*stack.pop());
                }else if (str.equals("/")){
                    Integer pop1 = stack.pop();
                    Integer pop2 = stack.pop();
                    stack.push(pop2/pop1);
                }else {
                    stack.push(Integer.valueOf(str));
                }
            }
            return stack.pop();
        }
    }
}
