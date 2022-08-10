package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRow {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth==1){
                TreeNode treeNode = new TreeNode(val);
                treeNode.left=root;
                return treeNode;
            }
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            int i=1;
            while (i<depth){
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    TreeNode poll = queue.poll();
                    if (poll.left!=null){
                        queue.offer(poll.left);
                    }
                    if (poll.right!=null){
                        queue.offer(poll.right);
                    }
                }
                i++;
            }
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode poll = queue.poll();
                TreeNode left = poll.left;
                poll.left=new TreeNode(val);
                poll.left.left=left;
                TreeNode right = poll.right;
                poll.right=new TreeNode(val);
                poll.right.right=right;

            }
            return root;
        }
    }
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
}
