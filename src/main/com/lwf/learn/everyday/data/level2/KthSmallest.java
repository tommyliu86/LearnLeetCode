package com.lwf.learn.everyday.data.level2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-11 16:18
 */
public class KthSmallest {
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
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack=new Stack<>();
            int i=0;
            while (!stack.isEmpty()||root!=null){
                while (root!=null){
                    stack.push(root);
                    root=root.left;
                }
                root=stack.pop();
                i++;
                if (i==k){
                    return root.val;
                }
                root=root.right;
            }
            return -1;
        }
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
