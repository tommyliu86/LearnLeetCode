package com.lwf.oneLearnOneday.normal;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * author Administrator
 * time 2019-10-26-23:06
 * {@link \Top100\src\md\normal\94.md}
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(com.lwf.TOP100.normal.TreeNode root) {
        Stack<com.lwf.TOP100.normal.TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        com.lwf.TOP100.normal.TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }
        return list;
    }
    public List<Integer> back(com.lwf.TOP100.normal.TreeNode root){
        List<Integer> l=new LinkedList<>();
        b(root,l);
        return l;
    }
    public void b(com.lwf.TOP100.normal.TreeNode node, List<Integer> list){
        if (node==null){
            return;
        }
        b(node.left,list);
        list.add(node.val);
        b(node.right,list);
    }
}

class TreeNode {
    int val;
    com.lwf.TOP100.normal.TreeNode left;
    com.lwf.TOP100.normal.TreeNode right;
    TreeNode(int x) { val = x; }
}
