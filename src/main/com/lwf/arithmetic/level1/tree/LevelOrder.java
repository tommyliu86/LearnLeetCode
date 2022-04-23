package com.lwf.arithmetic.level1.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-14 21:09
 */
public class LevelOrder {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> rtn = new ArrayList<>();
            if (root == null) {
                return rtn;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list=new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    list.add(poll.val);
                    if (poll.left!=null){
                        queue.add(poll.left);
                    }
                    if (poll.right!=null){
                        queue.add(poll.right);
                    }
                }
                rtn.add(list);
            }
            return rtn;
        }
    }
}
