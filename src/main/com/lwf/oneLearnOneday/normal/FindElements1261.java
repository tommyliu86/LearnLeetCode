package com.lwf.oneLearnOneday.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * 1261. 在受污染的二叉树中查找元素
 *
 * @author: liuwenfei
 * @date: 2024/3/12-9:36
 */
public class FindElements1261 {
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

    /**
     * 树中的节点正好是满二叉树的层序遍历的index
     */
    class FindElements {

        public FindElements(TreeNode root) {
            root.val = 0;
            set.add(0);
            dfs(root);
        }
        Set<Integer> set=new HashSet<>();
        void dfs(TreeNode node) {
            if (node == null)
                return;
            if (node.left != null){
                node.left.val = node.val * 2 + 1;
                set.add(node.left.val);
            }
            if (node.right != null) {
                node.right.val = node.val * 2 + 2;
                set.add(node.right.val);
            }
            dfs(node.left);
            dfs(node.right);
        }


        public boolean find(int target) {
            return set.contains(target);
        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
}
