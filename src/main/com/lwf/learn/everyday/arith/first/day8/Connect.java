package com.lwf.learn.everyday.arith.first.day8;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author: liuwenfei14
 * @date: 2022-04-07 09:19
 */
public class Connect {

    // Definition for a Node.
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

    /**
     * 利用next节点的特点进行层序遍历，是链表的应用！
     */
    class test {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Node cusor = root;
            while (cusor != null) {
                Node curr = cusor;
                while (curr != null && curr.left != null) {
                    curr.left.next = curr.right;
                    if (curr.next != null) {
                        curr.right.next = curr.next.left;
                    }
                    curr = curr.next;
                }
                cusor = cusor.left;
            }
            return root;
        }
    }

    /**
     * 数的层序遍历（bfs的应用）
     */
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Queue<Node> queue = new LinkedList<>();
            ((LinkedList<Node>) queue).add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node pre = null;
                Node next = null;
                for (int i = 0; i < size; i++) {
                    next = queue.poll();
                    if (pre != null) {
                        pre.next = next;
                    }
                    pre = next;

                    if (next.left != null) {
                        ((LinkedList<Node>) queue).add(next.left);
                    }
                    if (next.right != null) {
                        ((LinkedList<Node>) queue).add(next.right);
                    }
                }
                if (pre != null) {
                    pre.next = null;
                }
            }
            return root;
        }
    }
}
