package com.lwf.classic.one;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/1/29 9:14
 */
public class LevelOrder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root==null)return Collections.emptyList();
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            List<List<Integer>> ans=new ArrayList<>();
            int deep=1;
            while (!queue.isEmpty()){
                List<Integer> sub=new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    sub.add(poll.val);
                    if (poll.left!=null) queue.offer(poll.left);
                    if (poll.right!=null) queue.offer(poll.right);
                }
                if (deep%2==0){
                 Collections.reverse(sub);
                }
                ans.add(sub);
                deep++;
            }
            return ans;
        }
    }
    class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root==null)return Collections.emptyList();
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            List<List<Integer>> ans=new ArrayList<>();
            while (!queue.isEmpty()){
                List<Integer> sub=new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    sub.add(poll.val);
                    if (poll.left!=null) queue.offer(poll.left);
                    if (poll.right!=null) queue.offer(poll.right);
                }

                ans.add(sub);
            }
            return ans;
        }
    }
    class Solution1 {
        public int[] levelOrder(TreeNode root) {
            Queue<TreeNode> queue=new LinkedList<>();
            List<Integer> list=new ArrayList<>();
            if (root==null){
                return new int[0];
            }
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    list.add(poll.val);
                    if (poll.left!=null) queue.offer(poll.left);
                    if (poll.right!=null) queue.offer(poll.right);
                }
            }
            int[] ans=new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i]=list.get(i);
            }
            return ans;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
