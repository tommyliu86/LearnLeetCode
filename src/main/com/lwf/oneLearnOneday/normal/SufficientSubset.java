package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/5/22 8:48
 */
public class SufficientSubset {
    /**
     * 后续遍历，先遍历子节点，判断最后的叶子节点的大小，如果叶子节点都移除，则当前节点也要移除，一次遍历之后，就会移除所有不符合要求的节点了
     */
    class Solution {
        int limit;
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            this.limit=limit;
            if (root==null||dfs(root,0)){
                return null;
            }
            return root;
        }
        public boolean dfs(TreeNode node,int sum){
            if (node.left==null&&node.right==null){
                if (sum+node.val<limit) {
                    return true;
                }
                return false;
            }
            boolean left=true;
            if (node.left!=null) {
                left=dfs(node.left,sum+node.val);
                if (left){
                    node.left=null;
                }
            }
            boolean right=true;
            if (node.right!=null){
                right=dfs(node.right,sum+node.val);
                if (right) node.right=null;
            }
            return left&&right;
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
