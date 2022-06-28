package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-24 10:42
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
            Queue<TreeNode> queue=new LinkedList<>();
            List<Integer> rtn=new ArrayList<>();
            if (root==null){
                return rtn;
            }
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                int max=Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    max=Math.max(poll.val,max);
                    if (poll.left!=null){
                        queue.add(poll.left);
                    }
                    if (poll.right!=null){
                        queue.add(poll.right);
                    }
                }
                rtn.add(max);
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
