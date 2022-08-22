package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintTree {
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
        public List<List<String>> printTree(TreeNode root) {
            int h = height(root);
            String[][] rtn = new String[h + 1][(1 << (h + 1)) - 1];
            for (int i = 0; i < rtn.length; i++) {
                Arrays.fill(rtn[i], "");
            }
            dfs(root, rtn, 0, rtn[0].length-1, 0);
            List<List<String>> lists = new ArrayList<>();
            for (int i = 0; i < rtn.length; i++) {

                List<String> list = new ArrayList<>(Arrays.asList(rtn[i]));
                lists.add(list);
            }
            return lists;
        }

        private void dfs(TreeNode node, String[][] rtn, int l, int r, int currH) {
            int m = (r - l) / 2 + l;
            rtn[currH][m] = String.valueOf(node.val);
            if (node.left != null) {
                dfs(node.left, rtn, l, m - 1, currH + 1);
            }
            if (node.right != null) {
                dfs(node.right, rtn, m + 1, r, currH + 1);
            }
        }

        private int height(TreeNode root) {
            if (root == null||(root.left==null&&root.right==null)) {
                return 0;
            }
            return Math.max(height(root.left), height(root.right));
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
