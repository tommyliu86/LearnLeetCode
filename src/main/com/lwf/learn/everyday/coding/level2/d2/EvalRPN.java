package com.lwf.learn.everyday.coding.level2.d2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 17:33
 */
public class EvalRPN {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack=new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                String token = tokens[i];
                Integer num;
                if (token.equals("+")){
                    num = stack.pop()+stack.pop();
                }else if (token.equals("-")){
                    num=stack.pop()*-1+stack.pop();
                }else if (token.equals("*")){
                    num=stack.pop()*stack.pop();
                }else if (token.equals("/")){
                    int n=stack.pop();
                    int m=stack.pop();
                    num=m/n;
                }else{
                   num=Integer.valueOf( token);
                }
                stack.push(num);
            }
            return stack.pop();
        }
    }
}
