package com.lwf;

/**
 * author Administrator
 * time 2019-08-26-22:37
 */
public class MaxDepth {
    private int maxdepth=0;
    public  int maxDepth(Node root){
        if (root==null) return 0;
        recurse(root,0);
        return maxdepth;
    }
    void recurse(Node node,int depth){
        if (node==null||node.children==null) return;
        else{
            depth++;
            maxdepth=Math.max(maxdepth,depth);
            for (Node child : node.children) {
                recurse(child,depth);
            }
        }
    }
}
