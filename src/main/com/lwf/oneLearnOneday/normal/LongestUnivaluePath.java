package com.lwf.oneLearnOneday.normal;

public class LongestUnivaluePath {
    /**
     * 暴力解法，直接深度遍历
     */
    class Solution {
        public int longestUnivaluePath(TreeNode root) {
            if (root==null){
                return 0;
            }
           single(root);
            return max-1;
        }
        int max=1;

        /**
         * 深度遍历时计算左右子树的单独高度作为返回值，同时在循环内部计算左右子树和当前节点是否相同作为max，一次遍历
         * @param node
         * @return
         */
        public int single(TreeNode node){
            if (node==null){
                return 0;
            }
            int left=single(node.left);

            int right=single(node.right);
            int sum=1;
            if (node.left!=null&&node.left.val==node.val){
                sum+=left;
                left++;
            }else{
                left=1;
            }
            if (node.right!=null&&node.right.val==node.val){
                sum+=right;
                right++;
            }else{
                right=1;
            }
            max=Math.max(sum,max);
            return  Math.max(left,right);

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
