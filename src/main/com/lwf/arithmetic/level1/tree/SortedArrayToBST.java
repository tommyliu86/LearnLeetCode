package com.lwf.arithmetic.level1.tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-14 21:12
 */
public class SortedArrayToBST {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return getTree(nums,0,nums.length-1);
        }
        private TreeNode getTree(int[] nums,int left,int right){
            if (left>right){
                return null;
            }
            TreeNode treeNode = new TreeNode();

            if (left==right){
                treeNode.val=nums[left];
                return treeNode;
            }
            int mid = (left + right) / 2;
            treeNode.val=nums[mid];
            treeNode.left=getTree(nums,left,mid-1);
            treeNode.right=getTree(nums,mid+1,right);
            return treeNode;


        }
    }
}
