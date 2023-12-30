package com.lwf.classic.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/1/13 14:44
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
            Map<Node,Node> map=new HashMap<>();
            Node newH=new Node(0);
            Node cursor=newH;
            while (head!=null){
                Node node = new Node(head.val);
                node.random=head.random;

                cursor.next=node;
                cursor=cursor.next;

                map.put(head,node);

                head=head.next;
            }
            cursor=newH.next;
            while (cursor!=null ){
                if (cursor.random!=null) {
                    cursor.random=map.get(cursor.random);
                }
                cursor=cursor.next;
            }
            return newH.next;
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
