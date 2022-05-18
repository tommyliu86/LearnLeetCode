package com.lwf.oneLearnOneday.normal;

import com.lwf.TOP100.normal.TreeNode;

import java.util.Stack;

/**
 * author Administrator
 * time 2019-10-31-23:07
 */
public class Flatten {
    public void flatten(com.lwf.TOP100.normal.TreeNode root) {
        if (root==null) return;
        Stack<com.lwf.TOP100.normal.TreeNode> stack = new Stack<>();
        stack.push(root);
        com.lwf.TOP100.normal.TreeNode current = null;
        com.lwf.TOP100.normal.TreeNode cursor = null;
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (cursor == null) {
                cursor = current;
            } else {
                cursor.left=null;
                cursor.right = current;
                cursor = cursor.right;
            }
            com.lwf.TOP100.normal.TreeNode left = current.left;
            com.lwf.TOP100.normal.TreeNode right = current.right;
            if (right != null) stack.push(right);
            if (left != null) {
                stack.push(left);
            }

        }

    }

}
