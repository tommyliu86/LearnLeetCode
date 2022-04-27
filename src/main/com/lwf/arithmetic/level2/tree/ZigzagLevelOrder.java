package com.lwf.arithmetic.level2.tree;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-26 14:01
 */
public class ZigzagLevelOrder {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> rtn = new ArrayList<>();
            if (root==null){
                return rtn;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            boolean left = true;
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list=new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode poll= queue.poll();
                    list.add(poll.val);
                    if (poll.left!=null){
                        queue.add(poll.left);
                    }
                    if (poll.right!=null){
                        queue.add(poll.right);
                    }
                }
                if (!left){
                    Collections.reverse(list);
                    left=true;
                }else{
                    left=false;
                }
                rtn.add(list);
            }
            return rtn;
        }
    }

    /**
     * 递归的层序遍历，需要遍历时维护层高
     */
    class bfs {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> rtn=new ArrayList<>();
            bfsRecursive(root,1,rtn);
            return rtn;
        }
        public void bfsRecursive(TreeNode node,int depth,List<List<Integer>> rtn){
            if (node==null){
                return;
            }
            if (rtn.size()<depth){
                rtn.add(new ArrayList<>());
            }
            bfsRecursive(node.left,depth+1,rtn);
            if (depth%2==0){
                rtn.get(depth-1).add(0,node.val);
            }else{
                rtn.get(depth-1).add(node.val);
            }
            bfsRecursive(node.right ,depth+1,rtn);
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
