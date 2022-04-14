package com.lwf.level1.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-13 19:33
 */
public class MaxDepth {
    class dfs {
        /**
         *
         *深度优先，迭代解法
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            if (root==null){
                return 0;
            }
            int left=0;
            if (root.left!=null) {
                left=maxDepth(root.left);
            }
            int right=0;
            if (root.right!=null) {
                right=maxDepth(root.right);
            }
            return Math.max(left,right)+1;
        }
    }
    class Solution {
        /**
         * 层序遍历
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            if (root==null) return 0;
            int depth=0;
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.left!=null){
                        ((LinkedList<TreeNode>) queue).add(poll.left);
                    }
                    if (poll.right!=null){
                        ((LinkedList<TreeNode>) queue).add(poll.right);
                    }
                }
                depth++;
            }
            return depth;
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
