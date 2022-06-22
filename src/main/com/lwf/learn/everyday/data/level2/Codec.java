package com.lwf.learn.everyday.data.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-11 19:49
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return "";
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()){

            for (int i = 0; i < queue.size(); i++) {
                TreeNode pop = ((LinkedList<TreeNode>) queue).pop();
                if (pop!=null){
                    builder.append(pop.val);
                    queue.add(pop.left);
                    queue.add(pop.right);
                }
                builder.append(",");

            }
        }
        return builder.substring(0,builder.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null|| data.equals("")){
            return null;
        }
        String[] split = data.split(",");

        Queue<TreeNode> queue=new LinkedList<>();
        int i=0;
        TreeNode root=new TreeNode(Integer.valueOf( split[i]));
        i++;
        queue.add(root);
        while (!queue.isEmpty()&&i<split.length){
            TreeNode pop = ((LinkedList<TreeNode>) queue).pop();
            String l = split[i++];
            if (l!=null&& !l.equals("")){
                pop.left=new TreeNode(Integer.valueOf(l));
                queue.add(pop.left);
            }
            if (i<split.length){

                String r = split[i++];
                if (r!=null&&!r.equals("")){
                    pop.right=new TreeNode(Integer.valueOf(r));
                    queue.add(pop.right);
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
