package com.lwf.oneLearnOneday.normal;

/**
 * from home
 * author: liuwu
 * time: 2024/2/24 18:41
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

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     */
    class SolutionPreIn {
        /**
         * 中-左-右，左中右，我们可以通过preorder，然后分割inorder的左右子树
         * @param preorder
         * @param inorder
         * @return
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return dfs(preorder,0,preorder.length,inorder,0,inorder.length);
        }
        public TreeNode dfs(int[] preorder,int p1,int p2,int[] inorder,int p3,int p4){
            if (p1>p2||p3>p4){
                return null;

            }
            TreeNode treeNode = new TreeNode(preorder[p1]);

            int m=-1;
            for (int i = p3; i <= p4; i++) {
                if (inorder[i]==preorder[p1]){
                    m=i;
                    break;
                }
            }
            treeNode.left=dfs(preorder,p1+1,p1+1+m-p3-1,inorder,p3,m-1);
            treeNode.right=dfs(preorder,p1+1+m-p3,p2,inorder,m+1,p4);
            return treeNode;
        }
    }


    /**
     * 106. 从中序与后序遍历序列构造二叉树
     * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/?envType=daily-question&envId=2024-02-22
     */
    class SolutionInPost {
        /**
         * 左-中-右，左右中，我们可以从后序中找到中，然后在中序中找到分隔点。仍然使用迭代分割
         *
         * @param inorder
         * @param postorder
         * @return
         */
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return (dfs(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1));
        }

        /**
         * 我们通过范围构建treenode
         *
         * @param postorder
         * @param p1
         * @param p2
         * @param inorder
         * @param p3
         * @param p4
         * @return
         */
        public TreeNode dfs(int[] postorder, int p1, int p2, int[] inorder, int p3, int p4) {
            if (p1 > p2 || p3 > p4) {
                return null;
            }
            //p2是中，然后我们在inorder中找到对应的p2的值
            TreeNode treeNode = new TreeNode(postorder[p2]);

            int m = -1;
            for (int i = p3; i <= p4; i++) {
                if (inorder[i] == postorder[p2]) {
                    m = i;
                    break;
                }
            }
            treeNode.left = dfs(postorder, p1, p1 + m - p3 - 1, inorder, p3, m - 1);
            treeNode.right = dfs(postorder, p1 + m - p3, p2 - 1, inorder, m + 1, p4);
            return treeNode;

        }
    }

    /**
     * 889. 根据前序和后序遍历构造二叉树
     * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/?envType=daily-question&envId=2024-02-22
     * 前序和后序，中-左右，左右-中，我们使用迭代，把左右子树拆范围。
     */
    class SolutionPrePost {
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            return dfs(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        /**
         * 每个方法返回范围内组成的node
         *
         * @param preorder
         * @param p1
         * @param p2
         * @param postorder
         * @param p3
         * @param p4
         * @return
         */
        public TreeNode dfs(int[] preorder, int p1, int p2, int[] postorder, int p3, int p4) {
            if (p1 > p2 || p3 > p4) {
                return null;
            }
            //pre 中的p1是中，post中的p4是中，因此，通过
            TreeNode treeNode = new TreeNode(preorder[p1]);
            //p1+1是一个树的中，p4-1是一个树的中，我们通过在p3~p4-1中找到p1+1的位置，可以分割出左的长和右的长

            //
            if (p1 == preorder.length - 1) {
                return treeNode;
            }
            int next = preorder[p1 + 1];
            int m = -1;
            for (int i = p3; i < p4; i++) {
                if (postorder[i] == next) {
                    m = i;
                    break;
                }
            }
            if (m != -1) {
                treeNode.left = dfs(preorder, p1 + 1, p1 + 1 + m - p3, postorder, p3, m);
                treeNode.right = dfs(preorder, p1 + 1 + m - p3 + 1, p2, postorder, m + 1, p4 - 1);
            }
            return treeNode;
        }
    }
}
