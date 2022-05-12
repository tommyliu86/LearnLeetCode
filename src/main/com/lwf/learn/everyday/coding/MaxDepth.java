package com.lwf.learn.everyday.coding;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-11 14:57
 */
public class MaxDepth {
    class Solution1 {
        public int maxDepth(TreeNode root) {
            return depth(root,0);
        }
        private int depth(TreeNode node,int depth){
            if (node==null){
                return depth;
            }
            return Math.max(depth(node.left,depth+1),depth(node.right,depth+1));
        }
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 1;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int depth = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.left != null) {
                        ((LinkedList<TreeNode>) queue).add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
                depth++;
            }
            return depth;
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
