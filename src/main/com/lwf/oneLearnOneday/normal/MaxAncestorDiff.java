package com.lwf.oneLearnOneday.normal;

/**
 * 1026. 节点与其祖先之间的最大差值
 *
 * @author liuwenfei
 * @date 2023/4/18 8:57
 */
public class MaxAncestorDiff {
    /**
     * 递归的深度优先遍历
     */
    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return Math.max(dfs(root.left,new int[]{root.val,root.val}),dfs(root.right,new int[]{root.val,root.val}));

        }
        public int dfs(TreeNode node,int[] minMax){
            if (node==null){
                return minMax[1]-minMax[0];
            }
            int min=Math.min(node.val,minMax[0]);
            int max=Math.max(node.val,minMax[1]);
            int l= dfs(node.left,new int[]{min,max});
            int r=dfs(node.right,new int[]{min,max});
            return Math.max(l,r);
        }
    }

    class Solution1026 {
        /**
         * 递归解法，最简单。。
         */
        public int maxAncestorDiff(TreeNode root) {
            int[] ints = dealNode(root);
            return ints[2];
        }

        public int[] dealNode(TreeNode node) {
            if (node == null) {
                return null;
            }
            int[] ans = new int[3];
            ans[0] = ans[1] = node.val;
            int[] left = dealNode(node.left);
            int[] right = dealNode(node.right);
            if (left != null) {
                ans[0] = Math.min(ans[0], left[0]);
                ans[1] = Math.min(ans[1], left[1]);
                ans[2] = Math.max(ans[2], Math.max(left[2], Math.max(Math.abs(node.val - left[0]), (Math.abs(node.val - left[1])))));
            }
            if (right != null) {
                ans[0] = Math.min(ans[0], right[0]);
                ans[1] = Math.min(ans[1], right[1]);
                ans[2] = Math.max(ans[2], Math.max(right[2], Math.max(Math.abs(node.val - right[0]), (Math.abs(node.val - right[1])))));
            }
            return ans;
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
