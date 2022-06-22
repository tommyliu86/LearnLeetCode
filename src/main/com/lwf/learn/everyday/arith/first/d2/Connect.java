package com.lwf.learn.everyday.arith.first.d2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-20 13:32
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
    class Solution1 {
        public Node connect(Node root) {
            if (root==null){
                return root;
            }
            Node pre=root;
            while (pre.left!=null){
                Node cursor=pre;
                while (cursor!=null){
                    cursor.left.next=cursor.right;
                    if (cursor.next!=null){

                        cursor.right.next= cursor.next.left;
                    }
                    cursor= cursor.next;
                }
                pre=pre.left;
            }
            return root;
        }
    }
    class Solution {
        public Node connect(Node root) {
            if (root==null||root.left==null||root.right==null){
                return root;
            }
            Queue<Node> queue=new LinkedList<>();
            ((LinkedList<Node>) queue).add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node pop = ((LinkedList<Node>) queue).pop();

                    if (i!=size-1){
                        pop.next=queue.peek();

                    }
                    if (pop.left!=null){
                        queue.add(pop.left);
                    }
                    if (pop.right!=null){
                        queue.add(pop.right);
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
    }
}
