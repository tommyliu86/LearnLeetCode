package com.lwf.oneLearnOneday.easy;

/**
 * @author: liuwenfei
 * @date: 2024/4/3-12:36
 */
public class GetTargetCopy {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序遍历，递归写法
     */
    class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            return dfs(cloned,target);
        }
        public TreeNode dfs(TreeNode node,TreeNode target){
            if (node==null){
                return null;
            }
            if (node.val==target.val){
                return node;
            }
            TreeNode left = dfs(node.left, target);
            if (left!=null){
                return left;
            }
            return dfs(node.right,target);
        }
    }
}
