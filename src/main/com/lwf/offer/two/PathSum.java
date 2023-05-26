package com.lwf.offer.two;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/5/26 9:42
 */
public class PathSum {
    /**
     * dfs 深度优先遍历
     * 注意需要考虑sum的int溢出，所以用long型
     */
    class Solution {
        int count = 0;

        public int pathSum(TreeNode root, int targetSum) {
            if (root==null) return 0;
            Map<Long,Integer> marks=new HashMap<>();
            marks.put(0L,1);
            dfs(root,targetSum,marks,0);
            return count;
        }

        public void dfs(TreeNode node, int targetSum, Map<Long, Integer> marks, long sum) {
            sum += node.val;
            if (marks.containsKey(sum - targetSum)) {
                count += marks.get(sum - targetSum);
            }
            if (node.left == null && node.right == null) return;
            marks.put(sum, marks.getOrDefault(sum, 0) + 1);
            if (node.left != null) dfs(node.left, targetSum, marks, sum);
            if (node.right != null) dfs(node.right, targetSum, marks, sum);
            marks.put(sum, marks.getOrDefault(sum, 0) - 1);
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
