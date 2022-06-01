package com.lwf.oneLearnOneday.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-30 10:08
 */
public class SumRootToLeaf {
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
        int sum = 0;

        public int sumRootToLeaf(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            recursive(root,list);
            return sum;
        }

        public void recursive(TreeNode node, List<Integer> list) {
            if (node!=null){

                list.add(node.val);
                if (node.left != null || node.right != null) {

                    if (node.left != null) {
                        recursive(node.left, list);
                    }
                    if (node.right != null) {
                        recursive(node.right, list);
                    }
                } else {
                    int s = 0;
                    for (int i = 0; i < list.size(); i++) {
                        s = s * 2 + list.get(i);
                    }
                    sum += s;
                }
                list.remove(list.size()-1);
            }

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
