package com.lwf.classic.two;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/6/15 9:30
 */
public class BSTIterator {
    Stack<TreeNode> stack=new Stack<>();
    public BSTIterator(TreeNode root) {
        push(root);
    }
    private void push(TreeNode node){
        while (node!=null){
            stack.push(node);
            node=node.left;
        }
    }
    private TreeNode pop(){
        if (!hasNext()){
            return null;
        }
        TreeNode pop = stack.pop();

        if (pop.right!=null){
            push(pop.right);
        }
        return pop;
    }
    public int next() {
        TreeNode pop = pop();
        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
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
