package com.lwf.arithmetic.level2.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-26 16:00
 */
public class Connect {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
    class test {
        public Node connect(Node root) {

            Node pre=root;
            while (pre!=null){
                Node first=null;
                Node cur=pre;
                Node cursor=null;
                while (cur!=null){
                    if (first==null){
                        first=cur.left==null?cur.right:cur.left;
                    }
                    if (cur.left!=null&&cur.right!=null) {
                        cur.left.next=cur.right;
                    }

                    if (cursor!=null){
                        cursor.next=cur.left==null?cur.right:cur.left;
                        while (cursor.next!=null){
                            cursor=cursor.next;
                        }
                    }else{
                        cursor=cur.right==null?cur.left:cur.right;
                    }

                    cur=cur.next;
                }
                pre=first;
            }
            return root;
        }
    }

    class Solution {
        public Node connect(Node root) {
            Queue<Node> queue = new LinkedList<>();
            if (root == null) {
                return root;
            }
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node pre = null;
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    if (pre == null) {
                        pre = poll;
                    } else {
                        pre.next = poll;
                        pre = pre.next;
                    }
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            }
            return root;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
