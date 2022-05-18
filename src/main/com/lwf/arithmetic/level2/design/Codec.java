package com.lwf.arithmetic.level2.design;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 11:12
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public static void main(String[] args) {
        String s="null,null,null,";
        String[] split = s.split(",");

        for (int i = 0; i < split.length; i++) {
            System.out.println(i);
            System.out.println(Integer.valueOf(split[i]));
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        if (root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> list=new ArrayList<>();
            boolean hasValue=false;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll==null){
                    builder.append("").append(',');
                }else{
                    builder.append(poll.val).append(',');
                    list.add(poll.left);
                    list.add(poll.right);
                    if (poll.left!=null||poll.right!=null){
                        hasValue=true;
                    }
                }
            }
            if (hasValue){
                for (int i = 0; i < list.size(); i++) {
                    queue.add(list.get(i));
                }
            }
        }
        if (builder.length()>0){
            return builder.delete(builder.length()-1,builder.length()).toString();
        }else{
            return builder.toString();
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null|| data.length()==0){
            return null;
        }
        String[] split = data.split(",");
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("null")){
                list.add(null);
            }else{
                list.add(Integer.valueOf(split[i]));
            }
        }
        Queue<TreeNode> queue=new LinkedList<>();
        int i=0;
        TreeNode root = new TreeNode(list.get(i));
        queue.add(root);
        i++;
        while (i<list.size()){
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode poll = queue.poll();

                Integer left = list.get(i++);
                if (left!=null){
                    TreeNode treeNode = new TreeNode(left);
                    queue.add(treeNode);
                    poll.left=treeNode;
                }
                Integer right = list.get(i++);
                if (right!=null){
                    TreeNode treeNode = new TreeNode(right);
                    queue.add(treeNode);
                    poll.right=treeNode;
                }
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

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));