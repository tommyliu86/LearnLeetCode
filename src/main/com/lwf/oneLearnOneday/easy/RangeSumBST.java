package com.lwf.oneLearnOneday.easy;

/**
 * 938. 二叉搜索树的范围和
 *
 * @author: liuwenfei
 * @date: 2024/2/26-9:08
 */
public class RangeSumBST {
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

    class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            return sum(root, low, high);
        }

        public int sum(TreeNode node, int low, int high) {
            if (node == null)
                return 0;
            //简便写法，直接进行全节点的遍历
            //return (node.val<low||node.val>high?0:node.val) +sum(node.left,low,high)+sum(node.right,low,high);

            //分情况进行计算，时间复杂度降低
            int ans = 0;
            if (node.val > low) {
                ans += sum(node.left, low, high);
            }
            if (node.val < high)
                ans += sum(node.right, low, high);

            if (node.val >= low && node.val <= high) {
                ans += node.val;
            }
            return ans;
        }
    }
}
