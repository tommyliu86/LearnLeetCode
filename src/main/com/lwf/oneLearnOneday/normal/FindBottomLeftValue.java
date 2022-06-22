package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 10:28
 */
public class FindBottomLeftValue {
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
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue=new LinkedList<>();
            TreeNode pre=null;
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = ((LinkedList<TreeNode>) queue).pop();
                    if (i==0){
                        pre=pop;
                    }
                    if (pop.left!=null){
                        queue.add(pop.left);
                    }
                    if (pop.right!=null){
                        queue.add(pop.right);
                    }
                }
            }
            return pre.val;
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
