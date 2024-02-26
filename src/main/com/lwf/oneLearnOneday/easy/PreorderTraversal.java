package com.lwf.oneLearnOneday.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: liuwenfei
 * @date: 2024/2/19-20:49
 */
public class PreorderTraversal {

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
     * 前序遍历的迭代写法
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }

            }
            return list;
        }

        /**
         * 中序遍历
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur=root;
            while (!stack.isEmpty()||cur!=null) {
                //中序，先把所有cur放入
                while (cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                }
                //弹出一个，是cur
                TreeNode pop = stack.pop();
                list.add(pop.val);
                //把游标设置成right，如果没有，则cur为空，进入下一个while循环后，会从stack中直接取一个pop
                if (pop.right!=null){
                    cur=pop.right;
                }

            }
            return list;
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur=root;
            TreeNode preUse=null;
            while (!stack.isEmpty()||cur!=null) {
                //把当前节点放入到栈，遍历左数
                while (cur != null) {
                    stack.push(cur);
                    cur=cur.left;
                }
                TreeNode pop = stack.pop();
                //如果right为空，或者当前节点的右数已经都已经遍历过了，那么就要记录并弹出
                if (pop.right == null||pop.right==preUse) {
                    list.add(pop.val);
                    preUse=pop;
                }else{
                    stack.push(pop);
                    cur=pop.right;
                }
            }
            return list;
        }
    }

    class Solution1 {
        List<Integer> list = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {

            recurse(root);
            return list;
        }

        public void recurse(TreeNode node) {
            if (node == null) {
                return;
            }
            list.add(node.val);
            recurse(node.left);
            recurse(node.right);
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            recurse2(root);
            return list;
        }

        public void recurse2(TreeNode node) {
            if (node == null) {
                return;
            }
            recurse2(node.left);
            list.add(node.val);
            recurse2(node.right);
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            recurse3(root);
            return list;
        }

        public void recurse3(TreeNode node) {
            if (node == null) {
                return;
            }
            recurse3(node.left);
            recurse3(node.right);
            list.add(node.val);
        }

    }
}
