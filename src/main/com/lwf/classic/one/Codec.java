package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/2/9 13:45
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String sept=",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll!=null){
                    stringBuilder.append(poll.val).append(sept);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }else{
                    stringBuilder.append(sept);
                }

            }
        }
        return stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length()).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")){
            return null ;
        }
        String[] split = data.split(sept);
        Queue<TreeNode> queue=new LinkedList<>();
        int i=1;
        TreeNode treeNode = new TreeNode(Integer.valueOf( split[0]));
        queue.offer(treeNode);
        while (i<split.length){
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode poll = queue.poll();
                if (i<split.length&& split[i]!=null&& !split[i].equals("")) {
                    poll.left=new TreeNode(Integer.valueOf(split[i]));
                    queue.offer(poll.left);
                }
                i++;
                if (i<split.length&& split[i]!=null&& !split[i].equals("")) {
                    poll.right=new TreeNode(Integer.valueOf(split[i]));
                    queue.offer(poll.right);
                }
                i++;
            }

        }
        return treeNode;
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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
