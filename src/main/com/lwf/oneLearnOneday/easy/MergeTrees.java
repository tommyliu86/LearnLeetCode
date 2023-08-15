package com.lwf.oneLearnOneday.easy;

/**
 * author Administrator
 * time 2019-09-19-23:24
 * {@link 617.md}
 */
public class MergeTrees {
    /**
     * 二叉树的递归调用
     */
    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1==null)return root2;
            if (root2==null)return  root1;
            root1.val+=root2.val;
            root1.left=mergeTrees(root1.left,root2.left);
            root1.right=mergeTrees(root1.right,root2.right);
            return root1;
        }
    }

    class Solution1 {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 != null && t2 != null) {
                t1.val += t2.val;
                t1.left = mergeTrees(t1.left, t2.left);
                t1.right = mergeTrees(t1.right, t2.right);
                return t1;
            } else {
                return t1 == null ? t2 : t1;
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
