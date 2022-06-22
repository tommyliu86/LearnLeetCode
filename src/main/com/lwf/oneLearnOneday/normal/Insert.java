package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-18 14:27
 */
public class Insert {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

    class Solution {
        public Node insert(Node head, int insertVal) {
            if (head==null){
                Node node = new Node(insertVal);
                node.next=node;
                return node;
            }
            Node cur=head;
            Node next=head.next;
            if (next==cur){
                Node node = new Node(insertVal);
                cur.next=node;
                node.next=next;
                return cur;
            }else{
                boolean find    =false;
                while (next!=head){

                    if (cur.val>next.val){
                        if (insertVal>=cur.val||insertVal<=next.val) {
                            Node node = new Node(insertVal);
                            cur.next=node;
                            node.next=next;
                            find=true;
                            break;
                        }
                    }else{
                        if (insertVal>=cur.val&&insertVal<=next.val){
                            Node node = new Node(insertVal);
                            cur.next=node;
                            node.next=next;
                            find=true;
                            break;
                        }
                    }

                    cur=cur.next;
                    next=next.next;
                }
                if (!find){

                    Node node = new Node(insertVal);
                    cur.next=node;
                    node.next=next;
                }
                return head;
            }

        }
    }
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
