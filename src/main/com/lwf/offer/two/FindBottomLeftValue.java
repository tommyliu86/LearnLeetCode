package com.lwf.offer.two;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuwenfei
 * @date 2023/5/23 9:25
 */
public class FindBottomLeftValue {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
    /**
     * bfs
     */
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            int left=root.val;
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (i==0) {
                        left=poll.val;
                    }
                    if (poll.left!=null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right!=null) {
                        queue.offer(poll.right);
                    }
                }
            }
            return left;
        }
    }

    /**
     * DFS 深度遍历，通过额外的两个值去记录访问过的层和左节点，先序遍历即可。
     */
    class Solution1 {
        public int findBottomLeftValue(TreeNode root) {
            left = root.val;
            dfs(root, 0);
            return left;
        }

        int left = 0;
        int maxl = 0;

        public void dfs(TreeNode node, int level) {
            if (level > maxl) {
                maxl = level;
                left = node.val;
            }
            if (node.left != null) dfs(node.left, level + 1);
            if (node.right != null) dfs(node.right, level + 1);
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
