package com.lwf.offer.two;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/6/13 9:07
 */
public class InorderSuccessor {

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            while (root!=null&& root.val!=p.val){
                if (root.val>p.val)root=root.left;
                if (root.val<p.val)root=root.right;
            }
            return root;
        }
    }

    /**
     * 使用栈进行中序遍历
     */
    class Solution1 {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            Stack<TreeNode> queue = new Stack<>();
            boolean cur = false;
            while (root != null || !queue.isEmpty()) {
                while (root != null) {
                    queue.push(root);
                    root = root.left;
                }
                TreeNode node = queue.pop();
                if (cur) {
                    return node;
                }
                if (node.val == p.val) {
                    cur = true;
                }
                root = node.right;
            }
            return null;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
