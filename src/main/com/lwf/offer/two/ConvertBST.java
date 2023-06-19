package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/6/15 9:25
 */
public class ConvertBST {
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
        int count=0;
        public TreeNode convertBST(TreeNode root) {
            if (root==null) return root;
            if (root.right!=null){
                convertBST(root.right);
            }
            //
            count+=root.val;
            root.val=count;

            if (root.left!=null){
                convertBST(root.left);
            }
            return root;
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
