package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/8/25 8:39
 */
public class GoodNodes {
    /**
     * dfs
     * 需要比较的是 当前节点 curNode.val >=max(prePath),因此dfs 即可
     */
    class Solution {
        int ans=0;
        public int goodNodes(TreeNode root) {
            dfs(root,root.val);
            return ans;
        }
        public void dfs(TreeNode node,int max){
            if (node==null)return;
            if (node.val>=max){
                ans++;
            }
            dfs(node.left,Math.max(max,node.val));
            dfs(node.right,Math.max(max,node.val));
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
