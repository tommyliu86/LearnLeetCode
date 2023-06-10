package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/6/8 9:02
 */
public class MaxPathSum {
    /**
     * 获取到的递归结果，如果需要判断是否大于0才进行计算，可以直接使用math.max来获取0和结果的比较值，这样会简单很多！！
     */
    class Solution {
        public int maxPathSum(TreeNode root) {
            maxSelf(root);
            return max;
        }
        int max=Integer.MIN_VALUE;
        public int maxSelf(TreeNode node) {
            if (node==null){
                return 0;
            }
            int maxL =Math.max( maxSelf(node.left),0);
            int maxR =Math.max( maxSelf(node.right),0);
            max=Math.max(max, node.val+maxL+maxR);
            return node.val+Math.max( maxL,maxR);
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
