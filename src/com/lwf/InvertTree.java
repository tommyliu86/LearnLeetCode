package com.lwf;




/**
 * author Administrator
 * time 2019-07-26
 */
public class InvertTree {

    /**
     * 思路，二叉树的翻转就是把左右节点进行交换的操作。使用简单的递归进行操作即可。
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
       Reverse(root);
       return root;
    }
    private void Reverse(TreeNode node){
        if (node==null){
            return;
        }
        TreeNode temp=node.left ;
        node.left=node.right;
        node.right=temp;
        Reverse(node.left);
        Reverse(node.right);
    }

    /**
     * 不使用多余方法，自身递归解题。最后返回的节点需要是root，也就是方法返回入参。
     * 因此从这个点出发设计递归思路,在方法中间进行left和right节点的递归交换。从而实现递归调用
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root==null) return root;
        TreeNode left = root.left;
        root.left=invertTree2(root.right);
        root.right=invertTree2(left);
        return root;
    }

}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}