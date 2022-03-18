package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-11-29 Time: 09:06
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return parent;
    }
    TreeNode parent=null;
    boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root==null) return false;
        boolean left=false;
        boolean right=false;
        boolean current=false;
        if (root==p||root==q) current=true;
        left=dfs(root.left,p,q);
        if (current&&left){
            parent=parent==null?root:parent;
            return true;
        }
        right=dfs(root.right,p,q);
        if ((current&&right)||(left&&right)){
            parent=parent==null?root:parent;
            return true;
        }
        return current||left||right;
    }
    boolean recursive(TreeNode root, TreeNode p, TreeNode q){
        if (root==null) return false;
        int left=0;
        int right=0;
        int current=0;
        if (root==p||root==q) current=1;
        left=dfs(root.left,p,q)?1:0;
        if (current+left+right>=2){
            parent=parent==null?root:parent;
            return true;
        }
        right=dfs(root.right,p,q)?1:0;
        if (current+left+right>=2){
            parent=parent==null?root:parent;
            return true;
        }
        return current+left+right>0;
    }
}
