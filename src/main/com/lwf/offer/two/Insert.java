package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/3/15 19:56
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
                Node node = new Node();
                node.val=insertVal;
                node.next=node;
                return node;
            }else{
                Node cursor=head;
                while (cursor.val!=insertVal&&cursor.next!=head){
                    if (cursor.val<=cursor.next.val){
                        if (cursor.val<insertVal&&insertVal<cursor.next.val){
                            break;
                        }
                    }else{
                        if (insertVal>=Math.max(cursor.val,cursor.next.val)||insertVal<=Math.min(cursor.val,cursor.next.val)){
                            break;
                        }
                    }
                    cursor= cursor.next;
                }

                Node node = new Node(insertVal);
                node.next=cursor.next;
                cursor.next=node;
            }
            return head;

        }
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
