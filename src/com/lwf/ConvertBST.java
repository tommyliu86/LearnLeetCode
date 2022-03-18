package com.lwf;

/**
 * author Administrator
 * time 2019-08-21-23:38
 * {@link 538.md}
 */
public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        after(root);
        return root;
    }
    int count=0;
    void after(TreeNode node){
        if (node==null) return;
        after(node.right);
        int temp=node.val;
        node.val+=count;
        count+=temp;
        after(node.left );
    }
}
