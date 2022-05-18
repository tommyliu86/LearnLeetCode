package com.lwf.learn.everyday.coding.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 15:33
 */
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
        public List<Integer> preorder(Node root) {
            List<Integer> rtn=new ArrayList<>();
            pre(root,rtn);
            return rtn;
        }
        public void pre(Node node,List<Integer> list){
            if (node==null){
                return;
            }
            list.add(node.val);
            for (int i = 0; i < node.children.size(); i++) {
                pre(node.children.get(i),list);
            }
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
