package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-24 10:26
 */
public class IsUnivalTree {
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
        public boolean isUnivalTree(TreeNode root) {
            if (root==null){
                return true;
            }
            if (root.left!=null){
                if (root.val!=root.left.val) {
                    return false;
                }else if (!isUnivalTree(root.left)){
                    return false;
                }
            }
            if (root.right!=null){
                if (root.val!=root.right.val){
                    return false;
                }else if (!isUnivalTree(root.right)){
                    return false;
                }
            }
            return true;
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
