package com.lwf.oldtime;

import java.util.Stack;

/**
 * author Administrator
 * time 2019-07-27
 */
public class MyQueue {

     Stack<Integer> stack1=new Stack<>();
     Stack<Integer> stack2=new Stack<>();
//     Stack<Integer> temp=new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }
    /**
     * stack是LIFO，而queue是FIFO,因此使用三个stack来进行模仿queue，每次入栈，进行一次全部出栈，再入栈
     * 从而使另外一个栈中变成first在栈顶。
     * 此处考虑欠妥，使用两个stack完全可以实现功能，在push时，先把元素全部出栈到stack2，压入stack1,后再全部入栈
     */
    /** Push element x to the back of queue. */
    public void push(int x) {
//        stack2.push(x);
//        while (!stack1.isEmpty()){
//            temp.push(stack1.pop());
//        }
//        while (!temp.isEmpty()){
//            stack2.push(temp.pop());
//        }
//        Stack<Integer> tem=stack1;
//        stack1=stack2;
//        stack2=tem;
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }


    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      return   stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
       return stack1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */