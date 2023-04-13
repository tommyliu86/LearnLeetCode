package com.lwf.offer.two.tow;

/**
 * @author liuwenfei
 * @date 2023/4/13 9:39
 */
public class Flatten {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

    class Solution {
        public Node flatten(Node head) {
            Node ans=head;
            while (head!=null){

                if (head.child!=null){
                    Node flatten = flatten(head.child);
                    Node next = head.next;

                    head.next=flatten;
                    flatten.prev=head;
                    head.child=null;

                    while (flatten.next!=null) flatten=flatten.next;
                    flatten.next=next;
                    if (next!=null){
                        next.prev=flatten;
                    }

                    head=next;
                }else{
                    head=head.next;
                }
            }
            return ans;
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
