package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-01 10:08
 */
public class GetAllElements {
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
        /**
         * 非递归法深度优先遍历，使用两个stack，在迭代时直接构建数组。速度比递归低了一个等级。。
         *
         * @param root1
         * @param root2
         * @return
         */
        public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {

            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            List<Integer> rtn = new ArrayList<>();
            while (!stack1.isEmpty() || root1 != null || !stack2.isEmpty() || root2 != null) {
                while (root1 != null) {
                    stack1.push(root1);
                    root1 = root1.left;
                }
                while (root2 != null) {
                    stack2.push(root2);
                    root2 = root2.left;
                }
                TreeNode peek1 = stack1.isEmpty() ? null : stack1.peek();
                TreeNode peek2 = stack2.isEmpty() ? null : stack2.peek();
                if (peek1!=null&&peek2!=null){

                    if (peek1.val < peek2.val) {
                        rtn.add(peek1.val);
                        TreeNode pop = stack1.pop();
                        root1 = pop.right;

                    } else {
                        rtn.add(peek2.val);
                        TreeNode pop = stack2.pop();
                        root2 = pop.right;
                    }
                }else{
                    if (peek1==null){
                        rtn.add(peek2.val);
                        TreeNode pop = stack2.pop();
                        root2 = pop.right;
                    }else{
                        rtn.add(peek1.val);
                        TreeNode pop = stack1.pop();
                        root1 = pop.right;
                    }
                }
            }
            return rtn;
        }

        /**
         * 递归获取每个treenode的 list，然后双指针合并list
         *
         * @param root1
         * @param root2
         * @return
         */
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            recursive(root1, l1);
            recursive(root2, l2);
            List<Integer> rtn = new ArrayList<>();
            int i1 = 0;
            int i2 = 0;
            while (i1 < l1.size() && i2 < l2.size()) {
                Integer n1 = l1.get(i1);
                Integer n2 = l2.get(i2);
                if (n1 < n2) {
                    rtn.add(n1);
                    i1++;
                } else {
                    rtn.add(n2);
                    i2++;
                }
            }
            if (i1 == l1.size()) {
                rtn.addAll(l2.subList(i2, l2.size()));
            } else {
                rtn.addAll(l1.subList(i1, l1.size()));
            }
            return rtn;
        }

        public void recursive(TreeNode node1, List<Integer> list) {
            if (node1 == null) {
                return;
            }
            recursive(node1.left, list);
            list.add(node1.val);
            recursive(node1.right, list);
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
