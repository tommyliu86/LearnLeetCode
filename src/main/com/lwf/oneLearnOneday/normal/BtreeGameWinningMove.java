package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/2/3 9:50
 */
public class BtreeGameWinningMove {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            int[][] counts=new int[n+1][3];
            int all=dfs(root,counts);
            int xCount=counts[x][0];
            int parent=all-xCount;
            int xLeft= counts[x][1];
            int xRight=counts[x][2];
            return parent > xCount || xLeft >all-xLeft || xRight > all-xRight;

        }
        private int dfs(TreeNode node,int[][] counts){
            if (node==null) return 0;
            int left = dfs(node.left, counts);
            int right = dfs(node.right, counts);
            counts[node.val][0]=1+left+right;
            counts[node.val][1]=left;
            counts[node.val][2]=right;
            return counts[node.val][0 ];
        }
    }
}
