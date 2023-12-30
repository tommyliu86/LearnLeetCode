package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/1/29 9:40
 */
public class IsSubStructure {
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
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A==null||B==null) return  false;
            if (isSub(B,A)) return true;
            return isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }
        public boolean isSub(TreeNode a,TreeNode b){
            if (b==null|| a.val!=b.val){
                return false;
            }
            boolean left=true,right=true;
            if (a.left!=null)left=isSub(a.left,b.left);
            if (a.right!=null)right=isSub(a.right,b.right);
            return left&&right;
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
