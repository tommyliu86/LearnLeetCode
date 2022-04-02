package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-22-22:50
 * {@link 543.md}
 */
public class DiameterOfBinaryTree {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        recurse(root);
        return max;
    }
    int recurse(TreeNode node){
        if (node==null||(node.left==null&&node.right==null)) return 0;
        int left=0;
        if(node.left !=null)
        left=recurse(node.left)+1;
        int right=0;
        if(node.right!=null) right= recurse(node.right)+1;
        max=Math.max(max,left+right);
        return Math.max(left,right);
    }
}
