package com.lwf.TOP100.easy;


/**
 * author Administrator
 * time 2019-09-11-23:13
 * {@link 101.md}
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;

        return recurse(root.left,root.right);
    }
    boolean recurse(TreeNode left,TreeNode right){
        if (left==null&&right==null) return true;
        if (left==null||right==null) return false;
       return  left.val==right.val&&recurse(left.left,right.right)&&recurse(left.right,right.left);
    }
}
  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
