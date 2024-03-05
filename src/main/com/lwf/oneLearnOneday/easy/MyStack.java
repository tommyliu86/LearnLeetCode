package com.lwf.oneLearnOneday.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 *
 * @author: liuwenfei
 * @date: 2024/3/4-9:26
 */
public class MyStack {

    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() {

    }

    /**
     * 利用栈相当于每次插入的位置在队列的头，因此我们使用两个队列，每次把插入元素先放入，然后把队列全部写入即可，这样相当于头插
     * @param x
     */
    public void push(int x) {
        Queue<Integer> tem = queue;
        queue = queue2;
        queue2 = tem;

        queue.add(x);
        while (!queue2.isEmpty()) {
            queue.add(queue2.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
