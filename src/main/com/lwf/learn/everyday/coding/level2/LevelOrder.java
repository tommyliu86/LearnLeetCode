package com.lwf.learn.everyday.coding.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-23 14:25
 */
public class LevelOrder {
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
        public List<List<Integer>> levelOrder(Node root) {
            Queue<Node> queue=new LinkedList<>();
            if (root!=null){
                ((LinkedList<Node>) queue).add(root);
            }
            List<List<Integer>> rtn=new ArrayList<>();
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> list=new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    list.add(poll.val);
                    if (poll.children!=null){

                        for (int j = 0; j < poll.children.size(); j++) {
                            queue.add(poll.children.get(j));
                        }
                    }
                }
                rtn.add(list);
            }
            return rtn;
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
