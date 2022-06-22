package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-11 19:01
 */
public class LowestCommonAncestor {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {


        /**
         * //1.如果找到p或q节点，则返回该节点。
         * 2.先找左、右子树，如果左右子树都不为null，则该节点就是。否则，应该在左，或右树中。
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root==null){
                return null;
            }
            if (root.val==p.val||root.val==q.val){
                return root;
            }
            TreeNode left=lowestCommonAncestor(root.left,p,q);
            TreeNode right=lowestCommonAncestor(root.right,p,q);
            if (left!=null&&right!=null){
                return root;
            }
            return left==null?right:left;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
