package com.lwf.oneLearnOneday.easy;

/**
 * author Administrator
 * time 2019-09-15-23:36
 * {@link 226.md}
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null||(root.left==null&&root.right==null)) return root;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
