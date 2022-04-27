package com.lwf.arithmetic.level2.tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-26 15:20
 */
public class BuildTree {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder,inorder,0,0,inorder.length-1);
        }

        public TreeNode buildTree(int[] prdorder, int[] inorder, int preI, int ileft, int iright) {
            int cur = prdorder[preI];
            TreeNode treeNode = new TreeNode(cur);
            if (ileft < iright) {
                int mid = ileft;
                for (int i = ileft; i <= iright; i++) {
                    if (inorder[i] == cur) {
                        mid = i;
                        break;
                    }
                }
                if (ileft<=mid-1){
                    treeNode.left = buildTree(prdorder, inorder, preI + 1, ileft, mid - 1);
                }
                if (mid+1<=iright){
                    treeNode.right = buildTree(prdorder, inorder, preI + 1+(mid-ileft), mid + 1, iright);
                }
            }
            return treeNode;
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
