package com.lwf;

/**
 * author Administrator
 * time 2019-08-28-22:41
 * {@link 563.md}
 */
public class FindTilt {
    int count=0;
    public int findTilt(TreeNode root) {
        sumofNode(root);
        return count;
    }
    int sumofNode(TreeNode node){
        if (node==null) {
            return 0;
        }
        int leftsum=sumofNode(node.left);
        int rightsum=sumofNode(node.right);
        count+=Math.abs(leftsum-rightsum);
        return node.val+leftsum+rightsum;
    }

}
