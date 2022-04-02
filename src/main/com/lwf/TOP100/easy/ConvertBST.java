package com.lwf.TOP100.easy;

/**
 * author Administrator
 * time 2019-09-17-23:16
 */
public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        postorder(root);
        return root;
    }
    int sum=0;
    void postorder(TreeNode node){
        if (node==null) return ;
        postorder(node.right);
        int temp=node.val;
        node.val+=sum;
        sum+=temp;
        postorder(node.left);
    }
}
