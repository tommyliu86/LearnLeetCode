package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/?envType=daily-question&envId=2023-10-30
 * @author liuwenfei
 * @date 2023/11/6 10:02
 */
public class Connect {
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

    class Solution {
        public Node connect(Node root) {
            if (root==null)return root;
            Queue<Node> queue=new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                Node pre=null;
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    if (pre!=null){
                        pre.next=poll;
                    }
                    pre=poll;
                    if (poll.left!=null)
                        queue.offer(poll.left);
                    if (poll.right!=null)
                        queue.offer(poll.right);
                }
            }
            return root;
        }
    }
}
