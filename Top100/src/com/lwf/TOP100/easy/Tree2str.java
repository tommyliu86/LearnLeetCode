package com.lwf.TOP100.easy;

/**
 * Created with IntelliJ IDEA.
 *https://leetcode-cn.com/problems/construct-string-from-binary-tree/submissions/
 * 606. 根据二叉树创建字符串
 * @author: liuwenfei14
 * @date: 2022-03-19 10:20
 */
public class Tree2str {

    class Solution {
        /**
         * 前序遍历，直接使用dfs深度优先遍历即可。
         * @param root
         * @return
         */
        public String tree2str(TreeNode root) {
            String dfs = dfs(root);
            return dfs;
        }
        private String dfs(TreeNode node){
            if (node==null){
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(node.val);
            String left=dfs(node.left);
            String right=dfs(node.right);
            if(right!=""){
                stringBuilder.append("(").append(left).append(")").append("(").append(right).append(")");
            }else if(left!=""){
                stringBuilder.append("(").append(left).append(")");
            }
            return stringBuilder.toString();
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
