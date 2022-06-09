package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-09 15:01
 */
public class DeleteNode {
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root==null){
                return root;
            }
            if (root.val==key){
                TreeNode left = root.left;
                TreeNode right = root.right;
                if (right==null){
                    return left;
                }
                if (left==null){
                    return right;
                }

                while (right!=null&&right.left!=null){
                    right=right.left;
                }
                right.left=left;
                return root.right;
            }
            if (root.val>key&&root.left!=null){
                root.left=deleteNode(root.left,key);
            }else if (root.val<key&&root.right!=null){
                root.right=deleteNode(root.right,key);
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
