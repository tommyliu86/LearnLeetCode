package com.lwf.classic.two;

/**
 * @author liuwenfei
 * @date 2023/3/14 20:13
 */
public class Flatten {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    //深度遍历，递归进行节点遍历即可
    class Solution {
        public Node flatten(Node head) {
            if (head==null) return null;
            tail(head);
            return head;
        }

        public Node tail(Node node){

            if (node.child!=null) {
                Node tail = tail(node.child);
                tail.next = node.next;
                if (node.next!=null){
                    node.next.prev=tail;
                }
                node.next = node.child;
                node.child.prev=node;
                node.child=null;
                return tail(tail);
            }else{
                if (node.next==null){
                    return node;
                }else{
                    return tail(node.next);
                }
            }
        }
    }
}
