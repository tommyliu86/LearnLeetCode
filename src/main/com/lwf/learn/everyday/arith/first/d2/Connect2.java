package com.lwf.learn.everyday.arith.first.d2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-20 14:42
 */
public class Connect2 {
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
            while (pre!=null){
                Node first=null; //下一层的头结点

                Node cur=pre; //当前层的开始
                Node nextCur=null; //下一层的游标，用来做连接
                while (cur!=null){
                    if (cur.left!=null){
                        if (first==null){
                            first=cur.left;
                        }
                        if (nextCur!=null){
                            nextCur.next=cur.left;
                            nextCur=nextCur.next;
                        }else{
                            nextCur=cur.left;
                        }
                    }
                    if (cur.right!=null){
                        if (first==null){
                            first=cur.right;
                        }
                        if (nextCur!=null){
                            nextCur.next=cur.right;
                            nextCur=nextCur.next;
                        }else{
                            nextCur=cur.right;
                        }
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
            if (root==null){
                return root;
            }
            Queue<Node> queue=new LinkedList<>();
            queue.add(root);
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
                        ((LinkedList<Node>) queue).add(pop.right);
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
