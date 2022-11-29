package com.lwf.oneLearnOneday.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2022/11/29 9:38
 */
public class NumColor {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int numColor(TreeNode root) {
            Set<Integer> set=new HashSet<>();
            dfs(root,set);
            return set.size();
        }
        private void dfs(TreeNode node ,Set<Integer> set){
            if (node==null){
                return;
            }
            set.add(node.val);
            dfs(node.left,set);
            dfs(node.right,set);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
