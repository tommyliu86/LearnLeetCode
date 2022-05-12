package com.lwf.learn.everyday.coding;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-12 10:37
 */
public class MyQueue {
    Stack<Integer> in=new Stack<>();
    Stack<Integer> out=new Stack<>();
    public MyQueue() {

    }

    public void push(int x) {
        while (!out.isEmpty()){
           in.push( out.pop());
        }
        out.push(x);
        while (!in.isEmpty()){
            out.push(in.pop());
        }
    }

    public int pop() {
       return out.pop();
    }

    public int peek() {
        return out.peek();
    }

    public boolean empty() {
        return out.isEmpty();
    }
}
