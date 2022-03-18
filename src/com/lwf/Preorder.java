package com.lwf;

import java.util.ArrayList;
import java.util.List;

/**
 * author Administrator
 * time 2019-08-30-0:01
 */
public class Preorder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> list=new ArrayList<>();
        pre(root,list);
        return list;
    }
   void pre(Node root,List<Integer> list){
        if (root==null) return;
        list.add(root.val);
        if (root.children!=null){

            for (int i = 0; i <root.children.size() ; i++) {
                pre(root.children.get(i),list);
            }
        }
    }
}



