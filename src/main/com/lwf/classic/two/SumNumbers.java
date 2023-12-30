package com.lwf.classic.two;

/**
 * @author liuwenfei
 * @date 2023/5/26 9:32
 */
public class SumNumbers {
    /**
     * dfs 深度优先遍历
     * 设dfs返回的是node的值，那么通过计算左子树+右子树的值 递归得到最终结果，因此dfs即可
     *
     */
    class Solution {
        public int sumNumbers(TreeNode root) {
            return dfs(root,0);
        }
        public int dfs(TreeNode node,int c){
            c=c*10+node.val;
            if (node.left==null&&node.right==null) return c;
            return (node.left==null?0:dfs(node.left,c))+(node.right==null?0:dfs(node.right,c));
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
