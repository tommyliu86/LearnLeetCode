package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/1/30 15:10
 */
public class TreeToDoublyList {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {
        public Node treeToDoublyList(Node root) {
            if (root==null){
                return root;
            }
            Node tail = pre(root);
            Node head=tail;
            while(head.left!=null){
                head=head.left;
            }
            head.left=tail;
            tail.right=head;
            return head;
        }
        public Node pre(Node node){
            if (node==null) return null;
            Node tail=node;
            Node left = pre(node.left);
            Node right = pre(node.right);
            if (left!=null) {
                left.right=node;
                node.left=left;
            }
            if (right!=null){
                tail=right;
                while (right.left!=null){
                    right=right.left;
                }
                right.left=node;
                node.right=right;
            }
            return tail;
        }
    }
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
