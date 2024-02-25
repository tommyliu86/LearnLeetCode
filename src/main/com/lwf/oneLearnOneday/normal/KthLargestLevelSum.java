package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * from home
 * author: liuwu
 * time: 2024/2/24 18:24
 */
public class KthLargestLevelSum {
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

    /**
     * 用 层序遍历，然后使用一个sortedList，直接获取到排序后的结果就行
     */
    class Solution {
        public long kthLargestLevelSum(TreeNode root, int k) {

            List<Long> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                long sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    sum += poll.val;
                    if (poll.left != null)
                        queue.add(poll.left);
                    if (poll.right != null)
                        queue.add(poll.right);
                }
                list.add(sum);
            }
            list.sort(Long::compareTo);

            if (list.size() < k) {
                return -1;
            } else {
                return list.get(list.size() - k);
            }

        }
    }
}
