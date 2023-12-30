package com.lwf.classic.two;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/6/15 9:38
 */
public class FindTarget {
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
        Set<Integer> set=new HashSet<>();
        public boolean findTarget(TreeNode root, int k) {
            if (root==null) return false;
            if (root.left!=null){
                if (findTarget(root.left,k)) {
                    return true;
                }
            }
            if (set.contains(k- root.val)) {
                return true;
            }else{
                set.add(root.val);
            }
            if (root.right!=null){
                if (findTarget(root.right,k)){
                    return true;
                }
            }
            return false;
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
