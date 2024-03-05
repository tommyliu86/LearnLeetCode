package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-08 09:15
 */
public class LevelOrder {
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
     * 590. N 叉树的后序遍历
     */
    class Solution {
        List<Integer> list=new ArrayList<>();
        public List<Integer> postorder(Node root) {
            dfs(root);
            return list;
        }
        public void dfs(Node node){
            if (node==null)
                return;
            for (Node child : node.children) {
                dfs(child);
            }
            list.add(node.val);

        }
    }

    /**
     * 589. N 叉树的前序遍历
     * 递归非常简单，迭代则需要考虑如何构建栈结构
     */
    class SolutionPreorder {
        List<Integer> list=new ArrayList<>();
        public List<Integer> preorder(Node root) {
            if (root==null)
                return list;

            list.add(root.val);
            for (Node child : root.children) {
                preorder(child);
            }
            return list;

        }

    }
    /**
     * 429. N 叉树的层序遍历
     */
    class SolutionLevelOrder {
        public List<List<Integer>> levelOrder(Node root) {

            List<List<Integer>> rtn = new ArrayList<>();
            if (root == null) {
                return rtn;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    list.add(poll.val);
                    queue.addAll(poll.children);
                }
                rtn.add(list);
            }
            return rtn;
        }
    }
}
