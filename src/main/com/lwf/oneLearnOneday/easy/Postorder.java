package com.lwf.oneLearnOneday.easy;

import java.util.*;

/**
 * @author: liuwenfei
 * @date: 2024/2/19-9:10
 */
public class Postorder {

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

    /**
     * 递归转迭代，参考思路仍然是用栈来进行模拟
     *
     */
    class Solution {
        /**
         * 后续 左右 中，N叉树的逻辑，是list-中
         * @param root
         * @return
         */
        public List<Integer> postorder(Node root) {
            List<Integer> ans = new ArrayList<>();
            if (root==null)
                return ans;
            Stack<Node> stack = new Stack<>();
            //stack 中存cur，类似于二叉树中，我们在出栈拿到这个节点后，可以找到右节点，我们需要能够找到这个节点的children中的后面节点，
            //完成遍历children才行
            Map<Node,Integer> map=new HashMap<>();
            Node cur=root;
            while (!stack.isEmpty()||cur!=null){
                while (cur!=null){
                    stack.push(cur);
                    map.put(cur,0);

                }
                Node pop = stack.pop();
                if (pop.children==null||  map.get(pop)==pop.children.size()){
                    ans.add(pop.val);
                }
            }
            return ans;
        }


    }

    /**
     * 数的前序、中序、后序，是对于节点 left，self，right的排列方式中self的位置
     */
    class Solution1 {

        public List<Integer> postorder(Node root) {
            List<Integer> list = new ArrayList<>();
            post(root, list);
            return list;
        }

        public void post(Node node, List<Integer> list) {
            if (node == null) {
                return;
            }
            if (node.children != null && node.children.size() > 0) {
                for (int i = 0; i < node.children.size(); i++) {
                    post(node.children.get(i), list);
                }
            }
            list.add(node.val);
        }
    }

}
