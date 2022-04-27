package com.lwf.arithmetic.level2.tree;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-26 18:15
 */
public class KthSmallest {
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

    class test {
        /**
         * dfs 递归
         *
         * @param root
         * @param k
         * @return
         */
        public int kthSmallest(TreeNode root, int k) {
            if (root==null){
                return -1;
            }

            if (root.left != null) {
               int left = kthSmallest(root.left, k);
                if (left != -1) {
                    return left;
                }
            }
            count++;
            if (count == k) {
                return root.val;
            }
            if (root.right != null) {
                int right = kthSmallest(root.right, k);
                if (right != -1) {
                    return right;
                }
            }
            return -1;
        }
        int count=0;
    }


    class Solution {
        /**
         * dfs 迭代遍历到第k个
         *
         * @param root
         * @param k
         * @return
         */
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            while (k > 0 && (!stack.isEmpty() || root != null)) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                TreeNode pop = stack.pop();
                k--;
                if (k == 0) {
                    return pop.val;
                }
                root = pop.right;
            }
            return root.val;
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
