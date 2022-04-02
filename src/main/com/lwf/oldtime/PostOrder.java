package com.lwf.oldtime;

import java.util.ArrayList;
import java.util.List;

/**
 * author Administrator
 * time 2019-08-30-0:01
 */
public class PostOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        post(root,list);
        return list;
    }
   void post(Node root,List<Integer> list){
        if (root==null) return;

        if (root.children!=null){
            for (int i = 0; i <root.children.size() ; i++) {
                post(root.children.get(i),list);
            }
        }
       list.add(root.val);
    }
}



