package com.lwf.learn.everyday.coding.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-26 11:27
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
            Node root=new Node(Integer.MIN_VALUE);

            Map<Node,Node> map1=new HashMap<>();
            Node cursor=root;
            Node cursor1=head;
            while (cursor1!=null){
                Node node = new Node(cursor1.val);
                cursor.next=node;

                map1.put(cursor1,node);

                cursor=cursor.next;
                cursor1=cursor1.next;
            }
            while (head!=null){
                if (head.random!=null){
                    Node node = map1.get(head);

                    Node node1 = map1.get(head.random);
                    node.random=node1;
                }
                head=head.next;
            }
            return root.next;
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
