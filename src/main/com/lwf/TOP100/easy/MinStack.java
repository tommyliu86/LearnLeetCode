package com.lwf.TOP100.easy;

import java.util.Stack;

/**
 * author Administrator
 * time 2019-09-12-0:12
 */
public class MinStack {
int min=Integer.MAX_VALUE;
Stack<Integer> minStack=new Stack<>();
Stack<Integer> stack=new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()||minStack.peek()>=x) {
            min=x;
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()){

            int pop= stack.pop();
            if (min==pop){
                minStack.pop();
                min=minStack.peek();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */