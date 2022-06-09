package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-08 11:24
 */
public class SortedArrayToBST {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return half(nums,0,nums.length-1);
        }
        public TreeNode half(int[] nums,int l,int r){
            if (l==r){
                return new TreeNode(nums[l]);
            }else if (l>r){
                return null;
            }else{

                int m=(l+r)/2;
                TreeNode treeNode = new TreeNode(nums[m]);
                treeNode.left=half(nums,l,m-1);
                treeNode.right=half(nums,m+1,r);
                return treeNode;
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
