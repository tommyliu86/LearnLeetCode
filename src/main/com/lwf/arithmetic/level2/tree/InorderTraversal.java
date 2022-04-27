package com.lwf.arithmetic.level2.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-26 13:43
 */
public class InorderTraversal {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> rtn=new ArrayList<>();
            recursive(root,rtn);
            return rtn;
        }
        public void recursive(TreeNode node, List<Integer> rtn){
            if (node==null){
                return;
            }
            recursive(node.left,rtn);
            rtn.add(node.val);
            recursive(node.right,rtn);
        }
    }
    class test {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> rtn=new ArrayList<>();
            Stack<TreeNode> stack=new Stack<>();

            while (!stack.isEmpty()||root!=null){
                while (root!=null){
                    stack.push(root);
                    root=root.left;
                }
                root = stack.pop();
                rtn.add(root.val);
                root=root.right;
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
