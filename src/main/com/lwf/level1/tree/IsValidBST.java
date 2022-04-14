package com.lwf.level1.tree;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-13 19:42
 */
public class IsValidBST {
    /**
     * 递归的深度优先遍历,由于要比较大小，中序遍历时需要使用一个指针保存前一个访问的节点，然后比较pre和current
     */
    class dfs {
        public boolean isValidBST(TreeNode root) {
            if (root==null){
                return true;
            }
            if (!isValidBST(root.left)){
                return false;
            }
            if (pre!=null&&pre.val>=root.val){
                return false;
            }
            pre=root;
            if (!isValidBST(root.right)){
                return false;
            }
            return true;
        }

        TreeNode pre;
    }
    /**
     * 非递归的深度优先遍历
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
           if (root==null) return true;
            Stack<TreeNode> stack=new Stack();

            TreeNode pre=null;

            //stack模拟 深度优先遍历时，是可以出现stack为空的！
            while (!stack.isEmpty()||root!=null){
                //模拟left向下移动到最底部
                while (root!=null){
                    stack.push(root);
                    root=root.left;
                }
                // root到达最左节点
                TreeNode pop = stack.pop();
                if (pre!=null&& pre.val >=pop.val){
                    return false;
                }
                pre=pop;
                //换成右节点，因此需要走大while
                root=pop.right;
            }
            return true;
        }

    }
}
