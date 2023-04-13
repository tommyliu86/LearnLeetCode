package com.lwf.offer.two.tow;

/**
 * @author liuwenfei
 * @date 2023/4/13 9:50
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
            }else{
                Node cur=head;
                //循环一圈或者直接找到相同的值，都停下来
                while (cur.next!=head&&cur.val!=insertVal){
                    if (cur.val>cur.next.val){
                        if (insertVal>=cur.val||insertVal<=cur.next.val){
                            break;
                        }
                    }else{
                        if (insertVal>=cur.val&&insertVal<=cur.next.val){
                            break;
                        }
                    }
                    cur=cur.next;
                }
                Node node = new Node(insertVal);
                Node next = cur.next;
                cur.next=node;
                node.next=next;
                return head;
            }
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
