package com.lwf.learn.everyday.coding.level2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-30 13:58
 */
public class BSTIterator {
    Stack<TreeNode> queue = new Stack<>();
    TreeNode iter;

    public BSTIterator(TreeNode root) {
        add(root);
    }

    private void add(TreeNode node) {
        while (node != null) {
            queue.add(node);
            node = node.left;

        }

        iter = queue.isEmpty() ? null : queue.pop();
    }

    public int next() {
        int rtn = iter.val;
        if (iter.right != null) {
            add(iter.right);
        } else {
            iter = queue.isEmpty()?null: queue.pop();
        }

        return rtn;
    }

    public boolean hasNext() {
        return !queue.isEmpty() || iter != null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
