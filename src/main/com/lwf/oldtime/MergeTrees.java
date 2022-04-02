package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-09-02-21:46
 * {@link 617.md}
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null){
            return t2;
        }else{
            t1.val+=t2==null?0:t2.val;
           if (t2!=null){
               t1.left=mergeTrees(t1.left,t2.left);
               t1.right =mergeTrees(t1.right,t2.right);
           }
        }
        return t1;
    }

}
