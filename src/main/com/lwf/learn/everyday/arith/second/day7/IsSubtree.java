package com.lwf.learn.everyday.arith.second.day7;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-19 09:36
 */
public class IsSubtree {
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
        /**
         * 递归，前序遍历比较
         * @param root
         * @param subRoot
         * @return
         */
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root==null){
                return false;
            }
            if (root.val==subRoot.val&&isSub(root,subRoot)){
                return true;
            }else{
                return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
            }
        }
        boolean isSub(TreeNode a,TreeNode b){
            if (a==null&&b==null){
                return true;
            }else if(a!=null&&b!=null){
                return a.val==b.val&&isSub(a.left,b.left)&&isSub(a.right,b.right);
            }else{
                return false;
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
