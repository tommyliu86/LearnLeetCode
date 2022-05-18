package com.lwf.oneLearnOneday.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * 653. 两数之和 IV - 输入 BST
 *
 * @author: liuwenfei14
 * @date: 2022-03-21 09:28
 */
public class FindTarget {
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
        /**
         * dfs 法，由于树是BST的，因此按照中序遍历正好是有序数组，
         * 1.使用一个max值计算第一个节点的值，就是后续元素可以有的最大值，超过该值的就不再计算了
         * 2.使用一个set来保存每个节点值对应的k-val，对递归到的节点 v 进行set查找是否包含，同时检查v>max作为终止条件。
         * 3.递归终止条件使用函数返回值单独计算，这样可以减少递归次数。
         * @param root
         * @param k
         * @return
         */
        public boolean findTarget(TreeNode root, int k) {

            dfs(root, k);
            return isHave;
        }

        Set<Integer> sets = new HashSet<>();
        boolean isHave = false;
        int max=Integer.MIN_VALUE;
        public boolean dfs(TreeNode node, int k) {
            if (node.left != null) {
                boolean isEndLeft = dfs(node.left, k);
                if (isEndLeft) {
                    return true;
                }
            }
            if (sets.contains(node.val)) {
                isHave = true;
                return true;
            }
            if (sets.isEmpty()) {

                max=Math.max(max,k - node.val);
            }
            if (node.val > max) {
                return true;
            }
            sets.add(k - node.val);
            if (node.right != null) {
                boolean isEndRight = dfs(node.right, k);
                if (isEndRight) {
                    return true;
                }
            }
            return false;
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
