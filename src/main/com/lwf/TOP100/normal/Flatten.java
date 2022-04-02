package com.lwf.TOP100.normal;

import java.util.Stack;

/**
 * author Administrator
 * time 2019-10-31-23:07
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if (root==null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode current = null;
        TreeNode cursor = null;
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (cursor == null) {
                cursor = current;
            } else {
                cursor.left=null;
                cursor.right = current;
                cursor = cursor.right;
            }
            TreeNode left = current.left;
            TreeNode right = current.right;
            if (right != null) stack.push(right);
            if (left != null) {
                stack.push(left);
            }

        }

    }

}
