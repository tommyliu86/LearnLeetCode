package com.lwf.classic.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liuwenfei
 * @date 2023/5/24 17:17
 */
public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            int count = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                stringBuilder.append(poll == null ? " ," : poll.val + ",");
                if (poll != null) {
                    if (poll.left != null) count++;
                    if (poll.right != null) count++;
                    list.add(poll.left);
                    list.add(poll.right);
                }
            }
            if (count != 0) {
                queue.addAll(list);
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int i=1;
        while (!queue.isEmpty()&&i<split.length){
            TreeNode poll = queue.poll();
            String left = split[i++];
            String right = split[i++];
            if (!left.equals(" ")){
                poll.left=new TreeNode(Integer.valueOf(left));
                queue.offer(poll.left);
            }
            if (!right.equals(" ")){
                poll.right=new TreeNode(Integer.valueOf(right));
                queue.offer(poll.right );
            }
        }
        return root;
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
