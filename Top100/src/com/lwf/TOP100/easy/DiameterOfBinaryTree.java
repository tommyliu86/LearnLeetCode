package com.lwf.TOP100.easy;

/**
 * author Administrator
 * time 2019-09-17-23:29
 * {@link 543.md}
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        reverse(root,1);
        return max;
    }
    int max=0;
    int reverse(TreeNode node,int depth){
        if (node==null) return depth-1;
      int left=  reverse(node.left,depth+1);
      int right=reverse(node.right,depth+1);
      max=Math.max(left+right-2*depth,max);
      return Math.max(left,right);
    }
}
