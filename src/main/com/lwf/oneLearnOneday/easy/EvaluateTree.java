package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/2/6 9:34
 */
public class EvaluateTree {
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
        public boolean evaluateTree(TreeNode root) {
            if (root.left==null){
                return root.val==1;
            }
            if (root.val==2){
                return (evaluateTree(root.left) | evaluateTree(root.right));
            }else{
                return (evaluateTree(root.left) & evaluateTree(root.right));
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
