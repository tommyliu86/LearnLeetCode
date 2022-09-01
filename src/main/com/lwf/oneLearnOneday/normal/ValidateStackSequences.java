package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidateStackSequences {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> queue=new Stack<>();
            int i=0;
            int pi=0;
            while (!queue.isEmpty()||i<pushed.length){
                if (i<pushed.length){
                    queue.push(pushed[i++]);
                }else{
                    return false;
                }
                while (!queue.isEmpty()&&queue.peek()==popped[pi]){
                    queue.pop();
                    pi++;
                }
            }
            return true;
        }
    }
}
