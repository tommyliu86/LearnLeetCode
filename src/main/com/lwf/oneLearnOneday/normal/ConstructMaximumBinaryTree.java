package com.lwf.oneLearnOneday.normal;

public class ConstructMaximumBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return recursive(nums,0,nums.length-1);
        }
        private TreeNode recursive(int[] nums,int l,int r){
            if (l>r){
                return null;
            }
            int i = findMax(nums, l, r);
            TreeNode treeNode = new TreeNode();
            treeNode.val=nums[i];
            treeNode.left=recursive(nums,l,i-1);
            treeNode.right=recursive(nums,i+1,r);
            return treeNode;
        }
        private int findMax(int[] nums,int l ,int r){
            int index=l;
            int max=nums[l];
            for (int i = l; i <=r; i++) {
                if (nums[i]>max){
                    index=i;
                    max=nums[i];
                }
            }
            return index;
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
