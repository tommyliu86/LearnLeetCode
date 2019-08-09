package com.lwf;

public class SumOfLeftLeaves {
    /**
     * 递归算法
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null){
            return 0;
        }
        int rtn=0;
        if(root.left!=null){
            if(root.left.left==null&&root.left.right==null){
                rtn+=root.left.val;
            }
            else
                rtn+=sumOfLeftLeaves(root.left);
        }
        if(root.right!=null){
            rtn+=sumOfLeftLeaves(root.right);
        }
        return rtn;
    }
}
