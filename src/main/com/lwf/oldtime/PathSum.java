package com.lwf.oldtime;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 该方法实现递归调用，也就是递归获取到从该节点向下计算直到最后一个节点的所有路径的可能性。
     * 要计算到所有可能性，就要计算该节点为起点向下直到叶子节点，以及左右子节点向下直到叶子节点的路径。
     * 因此拆分为了两部分，第二个方法实现单一功能。一路向下，计算遍历到的所有路径中的和是否为目标值，
     * 第一个方法则实现循环递归对左右子节点的所有路径的可能性的计算。
     * @param node
     * @param sum
     * @param pathsum
     * @return
     */
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
     * 回溯？回溯点在于从保存所有和值的map中，在进行完左右子节点的计算后，要减去当前节点的和值返回上层，这样在上层使用map的时候
     * 不会带入下层存在的和!
     * 思路：考虑计算一个数组中的所有和值满足条件的子数组，的问题。计算方法为遍历相加，获取每一位处的向前的和，
     * 该位上向前的子数组和=sumK-sumJ，K>J，
     * 因此对树进行前序遍历，获取到每个节点的到根的和sumK，计算向上的所有父节点的sumK-sumJ，k j为节点深度
     * 就可以一次遍历获取到所有的可能性。该方法仅需要使用回溯进行sumMap的维护即可！
     * @param root
     * @param sum
     * @return
     */
    public int pathSum1(TreeNode root, int sum) {
        return backTracking(root,sum,0,new HashMap<Integer, Integer>());

    }
    int backTracking(TreeNode node, int sum, int pathsum, Map<Integer,Integer> sumList){
        if (node==null) return 0;
        int rtn=0;
        pathsum+=node.val;
        if (pathsum==sum) rtn++;
        rtn+=sumList.getOrDefault((pathsum-sum),0);
        sumList.put(pathsum, sumList.getOrDefault(pathsum,0)+1);
        rtn+=backTracking(node.left,sum,pathsum,sumList)+backTracking(node.right,sum,pathsum,sumList);
        sumList.put(pathsum,sumList.getOrDefault(pathsum,0)-1);
        return rtn;
    }
}
