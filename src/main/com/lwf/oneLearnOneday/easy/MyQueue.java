package com.lwf.oneLearnOneday.easy;

import java.util.Stack;

/**
 * @author: liuwenfei
 * @date: 2024/3/4-9:13
 */
public class MyQueue {

        Stack<Integer> stack=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        public MyQueue() {

        }

    /**
     * 使用两个栈，FILO 再进行一次操作之后，会变成FIFO，这样就实现了栈到队列的转换
     * @param x
     */
    public void push(int x) {

            while (!stack.isEmpty()){
                stack2.push(stack.pop());
            }
            stack.push(x);
            while (!stack2.isEmpty()){
                stack.push(stack2.pop());
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
