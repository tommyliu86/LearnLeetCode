package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/1/30 15:39
 */
public class KthLargest {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 后续遍历，找到k
         * @param root
         * @param k
         * @return
         */
        Integer ks=null;
        public int kthLargest(TreeNode root, int k) {
            dfs(root,0,k);
            return ks;
        }
        public int dfs(TreeNode node,int i,int k){
            if (node==null){
                return i;
            }
            i = dfs(node.right, i, k);
            if (i>k){
                return i;
            }
            if (++i==k){
                ks=node.val;
                return i+1;
            }
            if (i<k){
                 return dfs(node.left, i, k);
            }
            return i;
        }
    }
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
