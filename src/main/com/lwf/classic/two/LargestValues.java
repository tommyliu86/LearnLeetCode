package com.lwf.classic.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liuwenfei
 * @date 2023/5/23 9:18
 */
public class LargestValues {
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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ans=new ArrayList<>();
            if (root==null) return ans;
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                int max=Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    max=Math.max(max,poll.val);
                    if (poll.left!=null) queue.offer(poll.left);
                    if (poll.right!=null) queue.offer(poll.right);

                }
                ans.add(max);
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
