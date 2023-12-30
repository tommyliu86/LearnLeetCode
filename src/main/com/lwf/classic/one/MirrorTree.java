package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/1/29 9:50
 */
public class MirrorTree {
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
        public boolean isSymmetric(TreeNode root) {
            if (root==null){
                return false;
            }
            return isMirror(root.left,root.right);
        }
        public boolean isMirror(TreeNode a,TreeNode b){
            if (a==null&&b==null) return true;
            if (a!=null&&b!=null&& a.val==b.val){
                return isMirror(a.left,b.right)&&isMirror(a.right,b.left);
            }else{
                return false;
            }
        }
        public TreeNode mirrorTree(TreeNode root) {
            if (root==null) {
                return root;
            }
            TreeNode temp=mirrorTree( root.left);
            root.left=mirrorTree( root.right);
            root.right=temp;
            return root;
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
