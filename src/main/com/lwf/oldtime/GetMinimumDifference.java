package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-21-23:03
 * {@link 530.md}
 */
public class GetMinimumDifference {
    int min=Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        mid(root);
        return min;
    }
    void mid(TreeNode node){
        if (node==null) return;
        mid(node.left);
        if (pre!=null){
            min= Math.min(min,node.val-pre.val);
        }
        pre=node;
        mid(node.right);
    }
}
