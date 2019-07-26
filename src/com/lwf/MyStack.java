package com.lwf;


import java.util.LinkedList;
import java.util.Queue;

public class MyStack {


    final Queue<Integer> queue=new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    /**
     * 每次都把最后入队的元素放到队列最前面，这样就可以保证队列中维护的是一个逆序
     * @param x
     */
    public void push(int x) {
        queue.add(x);
        int size=queue.size();
        while(size>1){
            queue.add(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
