package com.lwf.learn.everyday.data.level2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-11 18:43
 */
public class BSTIterator {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cursor;

    public BSTIterator(TreeNode root) {
        cursor = root;
        while (cursor != null) {
            stack.push(cursor);
            cursor = cursor.left;
        }
        cursor=stack.pop();
    }

    public int next() {
        int val = cursor.val;
        cursor=cursor.right;
        while (cursor != null) {
            stack.push(cursor);
            cursor = cursor.left;
        }
        cursor=stack.isEmpty()?null: stack.pop();
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty()||cursor!=null;
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
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
