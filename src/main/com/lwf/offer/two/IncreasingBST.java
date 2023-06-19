package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/6/13 8:59
 */
public class IncreasingBST {
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
        public TreeNode increasingBST(TreeNode root) {
            if (root==null) return null;
            TreeNode left = increasingBST(root.left);
            TreeNode cur=left;
            if (left==null){
                left=root;
                cur=root;
            }else{
                while (cur.right!=null){
                    cur=cur.right;
                }
                cur.right=root;
                root.left=null;

            }
            TreeNode right = increasingBST(root.right);
            root.right=right;
            return left;
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
