package com.lwf.learn.everyday.arith.second.day7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/submissions/
 * @author: liuwenfei14
 * @date: 2022-04-19 09:50
 */
public class Connect {
    class dp {

        /**
         * 巧用链表，next构建完成之后，每一层都是一个nodelist，因此可以直接利用nodelist做遍历
         * 注意判断边界条件。转移next的条件判断
         * @param root
         * @return
         */
        public Node connect(Node root) {
            if (root==null){
                return null;
            }

            Node cursor = root;
            Node pre = null;
            Node next = null;
            while (cursor != null) {
                Node left = null;
                Node right = null;
                if (cursor.left != null && cursor.right != null) {
                    cursor.left.next = cursor.right;
                    left = cursor.left;
                    right = cursor.right;
                } else {
                    left = cursor.left != null ? cursor.left : cursor.right;
                    right = left;
                }
                if (left!=null){
                    if (pre==null){
                        next=left;
                    }else{
                        pre.next=left;
                    }
                    pre=right;
                }
                cursor = cursor.next;
            }
            connect(next);
            return root;
        }
    }

    class Solution {
        /**
         * 广度优先遍历，层序遍历方法。queue是额外空间
         * @param root
         * @return
         */
        public Node connect(Node root) {
            Queue<Node> queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node pre = null;
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    if (pre != null) {
                        pre.next = poll;
                    }
                    pre = poll;

                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
                pre.next = null;
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
