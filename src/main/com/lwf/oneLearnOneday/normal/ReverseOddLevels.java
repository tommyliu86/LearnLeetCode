package com.lwf.oneLearnOneday.normal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2415. 反转二叉树的奇数层
 * @author liuwenfei
 * @date 2023/12/15 9:15
 */
public class ReverseOddLevels {

    /**
     * 广度优先遍历
     */
    class Solution {
        /**
         * QUEUE中保存的是标准顺序的node，然后取出来之后，如果需要反向，则进行反向，
         */
        public TreeNode reverseOddLevels(TreeNode root) {
            if (root == null) return root;
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> pre = new LinkedList<>();
            queue.add(root);
            int degree = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();

                Deque<TreeNode> cur = new LinkedList<>();

                for (int i = 0; i < size; i++) {
                    //保存弹出的node
                    TreeNode poll = queue.poll();
                    cur.add(poll);

                    //保存当前层node
                    if (poll.left != null) queue.add(poll.left);
                    if (poll.right != null) queue.add(poll.right);


                }
                int size1 = pre.size();
                if (size1==0){
                    pre.addAll(cur);
                }else{

                    for (int i = 0; i < size1; i++) {
                        TreeNode poll = pre.poll();

                        //是奇数需要反向
                        if (degree % 2 == 1) {
                            poll.left = cur.pollLast();
                            poll.right = cur.pollLast();
                        } else {
                            poll.left = cur.pollFirst();
                            poll.right = cur.pollFirst();
                        }
                        pre.add(poll.left);
                        pre.add(poll.right);
                    }
                }
                degree++;
            }
            return root;
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
