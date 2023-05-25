package com.lwf.offer.two;

import java.util.IdentityHashMap;

/**
 * @author liuwenfei
 * @date 2023/5/24 17:03
 */
public class PruneTree {
    /**
     * 深度遍历
     */
    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            boolean dfs = dfs(root);
            if (dfs)return null;
            return root;
        }
        public boolean dfs(TreeNode node){
            boolean left=true,right=true;
            if (node.left!=null){
                left = dfs(node.left);
            }
            if (left) node.left=null;
            if (node.right!=null){
                right=dfs(node.right);
            }
            if (right)node.right=null;
            return node.val==0&&left&&right;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
