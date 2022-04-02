package com.lwf.TOP100.normal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-12-17 Time: 09:42
 */
public class Rob {
    public int rob(TreeNode root) {
        int[] rtns=recursive(root);
        return Math.max(rtns[0],rtns[1]);
    }

    /**
     * 利用tree的递归，获取每个节点node的两个值，分别是用currnode.val 和不用。
     * currnode[]=val+left[1]+right[1],max(left[])+max(right[]),当用val的时候，则是取left、right的不用时的值
     * 该值表示不用当前节点的最大值，形成递归
     * @param node
     * @return
     */
    int[] recursive(TreeNode node){
        if (node==null){
            return new int[]{0,0};
        }
        int[] left=recursive(node.left);
        int[] right=recursive(node.right);
        return new int[]{node.val+left[1]+right[1],Math.max(left[0],left[1])+Math.max(right[0],right[1])};
    }

    /**
     * 中序遍历，left-mid-right
     * @param root
     */
    void mid(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();

        int token=0;
        int notoken=0;
        TreeNode current=root;
        while (!stack.isEmpty()||current!=null){
            while (current!=null){
                stack.add(current);
                current=current.left;
            }
            current=stack.pop();
            //处理节点，此时的节点时left
            current=current.right ;
        }
    }

    void pre(TreeNode root){
        if (root!=null){

            System.out.println(root.val);
            pre(root.left);
            pre(root.right);
        }
    }
    void  pre1(TreeNode root){
        Stack<TreeNode> stack =new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode temp=stack.pop();
            System.out.println(temp.val);
            stack.add(temp.right);
            stack.add(temp.left);
        }
    }

}
