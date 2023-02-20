package com.lwf.offer.one;


/**
 * @author liuwenfei
 * @date 2023/2/1 15:35
 */
public class LowestCommonAncestor {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    /**
     * 1.后序遍历，计数
     * 2.哈希表，记录所有节点-》父节点的映射，然后找两个节点向上的父路径的第一个交点
     * 3.
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            this.p=p.val;
            this.q=q.val;
            dfs(root);
            return ans;
        }
        int p;
        int q;
        TreeNode ans;
        private int dfs(TreeNode node){
            if (node==null) return 0;
            int l=  dfs(node.left);

            int r= dfs(node.right);
            if (ans!=null){
                return r+l;
            }
           if (l+r==2){
               ans=node;
               return 2;
           }else if (l+r==1&&(node.val==p||node.val==q)){
               ans=node;
               return 2;
           }else{
             return   l+r+((node.val==p||node.val==q)?1:0);
           }
        }
    }
    class Solution1 {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (p.val> q.val) {
                TreeNode t=p;
                p=q;
                q=t;
            }
            if (root.val>q.val){
                return lowestCommonAncestor(root.left,p,q);
            }else if (root.val<p.val){
                return lowestCommonAncestor(root.right,p,q);
            }
            return root;

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
