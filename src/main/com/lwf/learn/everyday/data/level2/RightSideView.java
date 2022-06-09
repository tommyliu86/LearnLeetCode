package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-09 13:44
 */
public class RightSideView {
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
        public List<Integer> rightSideView(TreeNode root) {
            Queue<TreeNode> qu=new LinkedList<>();
            List<Integer> list=new ArrayList<>();
            if (root==null){
                return list;
            }
            qu.add(root);
            while (!qu.isEmpty()){
                int size = qu.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = qu.poll();
                    if (poll.left!=null){
                        qu.add(poll.left);
                    }
                    if (poll.right!=null){
                        qu.add(poll.right);
                    }
                    if (i==size-1){
                        list.add(poll.val);
                    }
                }
            }
            return list;
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
