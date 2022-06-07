package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-07 10:50
 */
public class MinStack {
    List<Integer> stack=new ArrayList<>();
    List<Integer> minIndex=new ArrayList<>();
    public MinStack() {

    }

    public void push(int val) {
        stack.add(val);
        if (!minIndex.isEmpty()){
            Integer index = minIndex.get(minIndex.size() - 1);
            if (stack.get(index)>=val) {
                minIndex.add(stack.size()-1);
            }
        }else{
            minIndex.add(stack.size()-1);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.remove(stack.size()-1);
            if (minIndex.get(minIndex.size()-1)==stack.size()) {
                minIndex.remove(minIndex.size()-1);
            }
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return stack.get(minIndex.get(minIndex.size()-1));
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