package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-09 14:18
 */
public class PathSum {
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

            List<List<Integer>> rtn = new ArrayList<>();
            if (root==null){
                return rtn;
            }
            recursive(root, rtn, new ArrayList<Integer>(), 0, targetSum);
            return rtn;
        }

        public void recursive(TreeNode node, List<List<Integer>> rtn, List<Integer> list, int sum, int t) {
            sum += node.val;
            list.add(node.val);
            if (node.left == null && node.right == null && sum == t) {
                rtn.add(new ArrayList<Integer>(list));

            } else if (node.left != null) {
                recursive(node.left, rtn, list, sum, t);
            } else if (node.right != null) {
                recursive(node.right, rtn, list, sum, t);
            }
            list.remove(list.size() - 1);
            sum-=node.val;
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
