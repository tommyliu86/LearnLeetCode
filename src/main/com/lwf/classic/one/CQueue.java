package com.lwf.classic.one;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/1/12 18:41
 */
public class CQueue {

        Stack<Integer> first=new Stack<>();
        Stack<Integer> second=new Stack<>();
        int count=0;
        public CQueue() {

        }

    /**
     * 不能每次放入都倒腾一次，最好的是在需要头出时候，把first都放入到second，这时候second放的就是要出的，first清空后继续加就行
     * @param value
     */
    public void appendTail(int value) {

            first.add(value);

            count++;
        }

        public int deleteHead() {
            if (count==0){
                return -1;
            }
            if (second.isEmpty()){
                while (!first.isEmpty()){
                    second.push(first.pop());
                }
            }
            count--;
            return second.pop();
        }


/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
