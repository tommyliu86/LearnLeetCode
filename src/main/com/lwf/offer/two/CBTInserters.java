package com.lwf.offer.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liuwenfei
 * @date 2023/5/17 9:21
 */
public class CBTInserters {
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

    class CBTInserter {
        TreeNode _root;
        List<TreeNode> _pre = new ArrayList<>();
        List<TreeNode> _sons = new ArrayList<>();
        int indez = 0;

        public CBTInserter(TreeNode root) {
            _root = root;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int d=0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<TreeNode> pre = new ArrayList<>();
                if (size  != (1<<d)) {
                    break;
                }
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    pre.add(poll);
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                _pre = pre;
            }
        }

        public int insert(int v) {
            if (_pre.size() >= indez) {
                _pre = _sons;
                _sons = new ArrayList<>();
                indez = 0;
            }
            int parent = v;
            while (true) {
                TreeNode treeNode = _pre.get(indez);
                if (treeNode.left == null && treeNode.right == null) {
                    treeNode.left = new TreeNode(v);
                    parent = treeNode.val;
                    break;
                } else if (treeNode.left != null && treeNode.right != null) {
                    _sons.add(treeNode.left);
                    _sons.add(treeNode.right);
                    indez++;
                } else {
                    if (treeNode.left == null) {
                        treeNode.left = new TreeNode(v);
                    } else {
                        treeNode.right = new TreeNode(v);
                    }
                    _sons.add(treeNode.left);
                    _sons.add(treeNode.right);
                    indez++;
                    parent = treeNode.val;
                    break;
                }
            }
            return parent;
        }

        public TreeNode get_root() {
            return _root;
        }
    }


}
