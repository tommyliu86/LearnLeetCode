package com.lwf.arithmetic.level1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-19 16:49
 */
public class MinStack {
    /**
     * 利用栈来保存栈中每个元素对应的栈内存在的最小值。做法是在该栈中每个元素都入参当前最小值，新入参的为Math.Min(curr,val)
     * 出栈时直接出栈即可
     */
    public class MinStack1 {
        Node curr;
        Node min;

        public MinStack1() {
            curr=new Node();
            min=new Node(Integer.MAX_VALUE);
        }

        public void push(int val) {
            curr= curr.insertNext(new Node(val));
           min= min.insertNext(new Node( Math.min(min.val,val)));
        }

        public void pop() {

            curr= curr.delete();
            min = min.delete();
        }

        public int top() {
            return curr.val;
        }

        public int getMin() {
           return min.val;
        }
        class Node{
            int val;
            Node pre;
            Node next;
            public Node(){

            }
            public  Node(int v){
                val=v;
            }
            public Node insertNext(Node n){
                this.next=n;
                n.pre=this;
                return next;
            }
            public Node delete(){
                this.pre.next=null;
                return this.pre;
            }
        }
    }

    /**
     * 利用优先队列的排序能力来构建队列排序，
     */
    Node curr;
    PriorityQueue<Node> queue=new PriorityQueue<>(Comparator.comparing(node -> node.val));
    public MinStack() {
        curr=new Node();
    }

    public void push(int val) {
       curr= curr.insertNext(new Node(val));
       queue.add(curr);
    }

    public void pop() {
        queue.remove(curr);
        curr= curr.delete();
    }

    public int top() {
        return curr.val;
    }

    public int getMin() {
        return queue.peek().val;
    }
    class Node{
        int val;
        Node pre;
        Node next;
        public Node(){

        }
        public  Node(int v){
            val=v;
        }
        public Node insertNext(Node n){
            this.next=n;
            n.pre=this;
            return next;
        }
        public Node delete(){
            this.pre.next=null;
            return this.pre;
        }
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
