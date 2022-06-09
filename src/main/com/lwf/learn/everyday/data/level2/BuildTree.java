package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-08 11:38
 */
public class BuildTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return half(preorder,0,inorder,0,inorder.length-1);
        }
        public TreeNode half(int[] pre,int pi,int[] in ,int il,int ir){
            if (pi>=pre.length||il>ir){
                return null;
            }
            TreeNode cur = new TreeNode(pre[pi]);
            int half=il;
            for (int i = il; i <= ir; i++) {
                if (in[i]==pre[pi]){
                    half=i;
                    break;
                }
            }

            cur.left=half(pre,pi+1,in,il,half-1);
            cur.right=half(pre,pi+1+half-il,in,half+1,ir);
            return cur;
        }

    }
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
}
