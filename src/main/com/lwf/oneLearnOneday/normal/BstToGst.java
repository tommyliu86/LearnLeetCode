package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/12/4 13:47
 */
public class BstToGst {
    /**
     * 倒叙遍历
     */
    class Solution {
        public TreeNode bstToGst(TreeNode root) {
            dfs(root);
            return root;
        }
        int sum=0;
        public void dfs(TreeNode node){
            if (node.right!=null){
                dfs(node.right);
            }
            sum+=node.val;
            node.val=sum;
            if (node.left!=null){
                dfs(node.left);
            }
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
