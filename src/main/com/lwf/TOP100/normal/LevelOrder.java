package com.lwf.TOP100.normal;



import java.util.*;

/**
 * author Administrator
 * time 2019-10-29-23:13
 */
public class LevelOrder {
    /**
     * 广度优先 BFS，此处难点在于想出如何统计当前层的节点个数，
     * 一次while循环中利用当前队列的size来当做当前层的节点个数计数器，一层遍历完成后
     * 刚好把下一层的所有节点都入队。完成了整个循环。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<List<Integer>> lists=new ArrayList<>();
        if (root==null) return lists;
        while (!queue.isEmpty()){
         List<Integer> list=new ArrayList<>();
            int levelCount=queue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode node=queue.poll();
                list.add(node.val);
                if (node.left!=null)queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            lists.add(list);

        }
        Collections.reverse(lists);
        return lists;
    }

    /**
     * 直接利用递归函数+level传递，实现list集合添加，
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
    return recursive(root,0,new ArrayList<List<Integer>>());
    }

    List<List<Integer>> recursive(TreeNode node ,int level,List<List<Integer>> list){
        if (node!=null){
            if (list.size()<level+1){
                list.add(level,new ArrayList<Integer>());
            }
            list.get(level).add(node.val);
            recursive(node.left ,level+1,list);
            recursive(node.right,level+1,list);

        }

        return list;

    }

}
