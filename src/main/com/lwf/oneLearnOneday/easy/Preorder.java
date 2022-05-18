package com.lwf.oneLearnOneday.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 589. N 叉树的前序遍历
 *
 * @author: liuwenfei14
 * @date: 2022-03-18 11:27
 */
public class Preorder {
    /**
     * 利用栈进行前序模拟 深度优先遍历
     */
    private class  test1{
        public List<Integer> preorder(Node root) {
            Stack<Node> stack=new Stack<>();
            List<Integer> list=new ArrayList<>();
            stack.push(root);
            while (!stack.isEmpty()){
                Node pop = stack.pop();
                if (pop!=null){

                    list.add(pop.val);
                    if (pop.children!=null){
                        Collections.reverse(pop.children);
                        for (Node child : pop.children) {

                            stack.push(child);
                        }
                    }
                }
            }
            return list;
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> list=new ArrayList<>();
        recurse(root,list);
        return list;
    }
    private void recurse(Node node,List<Integer> list){
        if (node!=null){
            list.add(node.val);
            if (node.children!=null) {
                node.children.forEach(
                        node1 -> recurse(node1,list)
                );
            }
        }else{
            return;
        }

    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
