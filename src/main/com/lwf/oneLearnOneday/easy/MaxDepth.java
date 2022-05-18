package com.lwf.oneLearnOneday.easy;

/**
 * author Administrator
 * time 2019-09-11-23:35
 */
public class MaxDepth {
    int maxdepth=0;
    public int maxDepth(TreeNode root) {
       recurse(root,0);
       return maxdepth;

    }
    void recurse(TreeNode node, int depth){
        if (node!=null){
            depth++;
            if (node.left==null&&node.right==null){
                maxdepth=Math.max(depth,maxdepth);
            }else{
                recurse(node.left,depth);
                recurse(node.right,depth);
            }

        }
    }
}
