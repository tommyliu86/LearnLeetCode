package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WidthOfBinaryTree {
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            int rtn=0;
            Queue<Pair> queue=new LinkedList<>();
            queue.offer(new Pair(root,0));
            while (!queue.isEmpty()){
                int size = queue.size();
                int min=Integer.MAX_VALUE;
                int max=0;
                for (int i = 0; i < size; i++) {
                    Pair poll = queue.poll();
                    if (i==0){
                        min=poll.value;
                    }
                    if (i==size-1){
                        max=poll.value;
                    }
                    if (poll.key.left!=null) {
                        queue.offer(new Pair(poll.key.left,poll.value*2+1));
                    }
                    if (poll.key.right!=null){
                        queue.offer(new Pair(poll.key.right,poll.value*2+2));
                    }
                }
                rtn=Math.max(rtn,max-min);
            }
            return rtn;
        }
        class Pair{
            TreeNode key;
            int value;
            public Pair(TreeNode k,int v){
                key=k;
                value=v;
            }
        }
    }
    /**
     * 利用层序遍历+数组存储完全二叉树的index来计算，完全二叉树的层序遍历，叶子节点的index=node*2+1，node*2+2.因此可以直接知道宽度
     */
    class Solution1 {
        public int widthOfBinaryTree(TreeNode root) {
            int rtn=0;
            Queue<Pair> queue=new LinkedList<>();
            queue.offer(new Pair(root,0));
            while (!queue.isEmpty()){
                int size = queue.size();
                int min=Integer.MAX_VALUE;
                int max=0;
                for (int i = 0; i < size; i++) {
                    Pair poll = queue.poll();
                    if (i==0){
                        min=poll.value;
                    }
                    if (i==size-1){
                        max=poll.value;
                    }
                    if (poll.key.left!=null) {
                        queue.offer(new Pair(poll.key.left,poll.value*2+1));
                    }
                    if (poll.key.right!=null){
                        queue.offer(new Pair(poll.key.right,poll.value*2+2));
                    }
                }
                rtn=Math.max(rtn,max-min);
            }
            return rtn;
        }
        class Pair{
            TreeNode key;
            int value;
            public Pair(TreeNode k,int v){
                key=k;
                value=v;
            }
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
