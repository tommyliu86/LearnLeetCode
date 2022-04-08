package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
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

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {

            List<List<Integer>> rtn = new ArrayList<>();
            if (root == null) {
                return rtn;
            }
            Queue<Node> queue = new LinkedList<>();
            ((LinkedList<Node>) queue).add(root);
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    list.add(poll.val);
                    ((LinkedList<Node>) queue).addAll(poll.children);
                }
                rtn.add(list);
            }
            return rtn;
        }
    }
}
