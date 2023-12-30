package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/2/3 10:30
 */
public class BuildTree {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder,0,inorder,0,inorder.length-1);
        }
        public TreeNode build(int[] preorder,int i, int[] inorder,int l,int r){
            if (l>r){
                return null;
            }
            TreeNode treeNode = new TreeNode(preorder[i]);
            int j=l;
            while (inorder[j]!=preorder[i])j++;
            treeNode.left=build(preorder,i+1,inorder,l,j-1);
            treeNode.right=build(preorder,i+1+(j-l),inorder,j+1,r);
            return treeNode;
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
