package com.lwf.TOP100.normal;



import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * author Administrator
 * time 2019-10-29-23:13
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode cur=root;
        while (!queue.isEmpty()||cur!=null){
            queue.add(cur);

        }
    }
}
