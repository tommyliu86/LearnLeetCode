package com.lwf;

/**
 * author Administrator
 * time 2019-08-12
 * {@link 437.md}
 */
public class PathSum {
    /**
     * 双重递归，使用嵌套。
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {

        return getCounter(root,sum,0);
    }
    int getCounter(TreeNode node,int sum,int pathsum){
        if (node==null) return 0;
        return getCount(node,sum,pathsum)+getCounter(node.left ,sum,0)+getCounter(node.right  ,sum,0);
    }
    int getCount(TreeNode node,int sum,int pathsum){
        if (node==null) return 0;
        int counter=0;
        pathsum+=node.val;
        if (pathsum==sum) counter ++;

            counter+=getCount(node.left ,sum,pathsum);

            counter+=getCount(node.right,sum,pathsum);

        return counter;
    }

    /**
     * 回溯
     * @param root
     * @param sum
     * @return
     */
    public int pathSum1(TreeNode root, int sum) {


    }
    void backTracking(TreeNode node,int sum,int pathsum,int count){
        if (node==null) return;
        pathsum+=node.val;
        if (pathsum==sum) count++;
        backTracking(node.left,sum,pathsum,count);
        pathsum-=node.val;
    }
}
