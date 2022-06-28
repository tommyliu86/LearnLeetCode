package com.lwf.learn.everyday.arith.first.d2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-27 16:46
 */
public class CopyRandomList {
    /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution {
        public Node copyRandomList(Node head) {
            if (head==null){
                return head;
            }
            Map<Node,Node> o2n=new HashMap<>();
            Node sec=new Node(head.val);
            sec.random=head.random;
            o2n.put(head,sec);

            Node newN=sec;
            Node cursor=head;
            while (cursor.next!=null){
                Node node = new Node(cursor.next.val);
                node.random=cursor.next.random;
                o2n.put(cursor.next,node);

                newN.next=node;
                newN=newN.next;
                cursor=cursor.next;
            }

            newN=sec;
            while (newN!=null){
                newN.random=o2n.get(newN.random);
                newN=newN.next;
            }
            return sec;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
