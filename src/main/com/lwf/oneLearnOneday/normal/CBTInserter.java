package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;

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
class CBTInserter {
    Queue<TreeNode> queue;
    TreeNode _root;

    public CBTInserter(TreeNode root) {
        queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        _root = root;
        queue.offer(root);
        while (!queue.isEmpty() && queue.peek().left != null && queue.peek().right != null) {

            TreeNode poll = queue.poll();
            queue.offer(poll.left);
            queue.offer(poll.right);

        }
    }

    public int insert(int val) {
        if (_root == null) {
            TreeNode treeNode = new TreeNode(val);
            _root = treeNode;
            queue.offer(treeNode);
            return -1;
        } else {
            TreeNode peek = queue.peek();
            if (peek.left == null) {
                peek.left = new TreeNode(val);
            } else {
                peek.right = new TreeNode(val);
                queue.offer(peek.left);
                queue.offer(peek.right);
                queue.poll();
            }
            return peek.val;
        }
    }

    public TreeNode get_root() {
        return _root;
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
/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
