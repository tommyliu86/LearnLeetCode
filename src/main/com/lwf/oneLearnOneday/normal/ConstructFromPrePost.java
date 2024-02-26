package com.lwf.oneLearnOneday.normal;

/**
 * @author: liuwenfei
 * @date: 2024/2/22-18:47
 */
public class ConstructFromPrePost {
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

    class Solution {
        /**
         * 中-左-右，左-右-中，
         * 我们使用 递归，每个范围内，可以找到左，右的取值范围，然后进行递归。每个中，在post中的尾巴
         *
         * @param preorder
         * @param postorder
         * @return
         */
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        }

        public TreeNode dfs(int[] preorder, int p1min,int p1max, int[] postorder, int p2min,int p2max) {
            if (p1min > p1max||p2min>p2max) {
                return null;
            }
            //pre 中的第一个是中节点，对应的应该是post的末尾节点
            TreeNode cur = new TreeNode(preorder[p1min]);
            //剩余的长度是 p1min+1~p1max,p2min~p2max-1,我们需要找到左数的真正长度

            int next=p1min+1;
            

            //pre指向的是前序的要查找的这个节点，可能是node的左或右，在post中查找，如果是post的紧接着的节点，则是右节点，否则是左节点，
            int p2 = p2pre;
            for (int i = p2pre; i < postorder.length; i++) {
                if (postorder[i] == preorder[p1]) {
                    p2 = i;
                    break;
                }
            }
            //
            if (p2==p2pre+1)
            TreeNode treeNode = new TreeNode(preorder[p1]);


            treeNode.left = dfs(preorder, p1 + 1, postorder, p2);
            treeNode.right = dfs(preorder, p1 + 1 + p2 - p2pre, postorder, p2pre + 1);

            return cur;
        }
    }
}
