package com.lwf.learn.everyday.th75;

import java.util.ArrayList;
import java.util.List;

public class Preorder {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        List<Integer> rtn=new ArrayList();
        public List<Integer> preorder(Node root) {
            if(root==null){
                return rtn;
            }
            rtn.add(root.val);
            if(root.children!=null){
                for(int i=0;i<root.children.size();i++){
                    preorder(root.children.get(i));
                }
            }
            return rtn;
        }
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
