package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxLevelSum {
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
        public int maxLevelSum(TreeNode root) {
            List<Integer> sums=new ArrayList<>();
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            int max=Integer.MIN_VALUE;
            while (!queue.isEmpty()){
                int size = queue.size();
                int sub=0;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    sub+=poll.val;
                    if (poll.left!=null){
                        queue.offer(poll.left);
                    }
                    if (poll.right!=null){
                        queue.offer(poll.right);
                    }
                }
                max=Math.max(sub,max);
                sums.add(sub);
            }
            for (int i = 0; i < sums.size(); i++) {
                if (sums.get(i)==max) {
                    return i;
                }
            }
            return 1;
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
