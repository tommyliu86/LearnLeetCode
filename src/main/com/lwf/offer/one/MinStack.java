package com.lwf.offer.one;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/1/12 18:56
 */
public class MinStack {
    /**
     * 单调栈
     */
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> min=new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()|| min.peek()>=x){
            min.push(x);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (min.peek().equals(pop)){
            min.pop();
        }
    }

    public int top() {
      return   stack.peek();
    }

    public int min() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */