package com.lwf.classic.one;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/2/8 15:37
 */
public class ValidateStackSequences {
    /**
     * 模拟
     */
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack=new Stack<>();
            int i=0;
            int j=0;
            while (i<popped.length){
                int pop = popped[i];
                while (j<pushed.length&& stack.isEmpty()||stack.peek()!=pop){
                    stack.push(pushed[j++]);
                }
                if (stack.peek()==pop){
                    stack.pop();
                    i++;
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
