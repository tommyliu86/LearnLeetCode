package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/2/1 15:02
 */
public class MaxDepth {
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
        public boolean isBalanced(TreeNode root) {
            if (root==null) return true;
            return depth(root) != -1;
        }
        private int depth(TreeNode node){
            if (node==null){
                return 0;
            }
            int left=depth(node.left);
            int right=depth(node.right);
            if (left==-1||right==-1) return -1;
            if (Math.abs( left-right)>1){
                return -1;
            }else{
                return Math.max(left,right)+1;
            }
        }
        public int maxDepth(TreeNode root) {
            int max=0;
            if (root==null)return max;
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
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
