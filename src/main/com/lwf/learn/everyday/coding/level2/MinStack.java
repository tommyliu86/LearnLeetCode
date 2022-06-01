package com.lwf.learn.everyday.coding.level2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-30 15:40
 */
public class MinStack {
    Stack<Integer> minS=new Stack<>();
    Stack<Integer> all=new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
        all.push(val);
        if (minS.isEmpty()|| minS.peek()>val) {
            minS.push(val);
        }
    }

    public void pop() {
        Integer pop = all.pop();
        if (minS.peek().equals(pop)) {
            minS.pop();
        }
    }

    public int top() {
        return all.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
