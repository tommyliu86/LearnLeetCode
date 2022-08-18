package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
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
        public int deepestLeavesSum(TreeNode root) {
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            int rtn=0;
            while (!queue.isEmpty()){
                int size = queue.size();
                int sub=0;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    sub+=poll.val;
                    if (poll.left!=null){
                        queue.add(poll.left);
                    }
                    if (poll.right!=null){
                        queue.add(poll.right);
                    }
                }
                if (queue.isEmpty()){
                    rtn=sub;
                }
            }
            return rtn;
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
