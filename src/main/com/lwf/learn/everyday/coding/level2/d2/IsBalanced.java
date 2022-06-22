package com.lwf.learn.everyday.coding.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 16:50
 */
public class IsBalanced {
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
        public boolean isBalanced(TreeNode root) {
            if (root==null){
                return true;
            }
            int left = treeH(root.left);
            if (left==-1){
                return false;
            }
            int right=treeH(root.right);
            if (right==-1){
                return false;
            }
            return Math.abs(left-right)<=1;
        }
        public int treeH(TreeNode node){
            if (node==null){
                return 0;
            }
            int left = treeH(node.left);
            if (left==-1){
                return -1;
            }
            int right=treeH(node.right);
            if (right==-1){
                return -1;
            }
            if (Math.abs( left-right)>1){
                return -1;
            }else{
                return Math.max(left,right)+1;
            }
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
