package com.lwf.learn.everyday.dp;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-16 13:08
 */
public class InorderSuccessor {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre=null;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                TreeNode pop = stack.pop();
                if (pre!=null&& pre.val==p.val){
                    return pop;
                }
                pre=pop;
                root=pop.right;
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
