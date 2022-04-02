package com.lwf.oldtime;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if (root.val==p.val||root.val==q.val||(root.val>p.val&&root.val<q.val)){
            return root;
        }
        else if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        while(!queue.isEmpty()){

        }
        if (root.val==p.val||root.val==q.val||(root.val>p.val&&root.val<q.val)){
            return root;
        }
        else if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
