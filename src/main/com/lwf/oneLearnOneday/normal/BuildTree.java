package com.lwf.oneLearnOneday.normal;

import com.lwf.TOP100.normal.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * author Administrator
 * time 2019-10-30-23:14
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        System.out.println(Arrays.copyOfRange(ints, 0, 1));
    }

    /**
     * 利用递归分别构建左右子树，preorder每次可以确认当前节点的值，而当前节点每次会切分出左右子树。
     * 执行时间内存50%，应该是index查找和数组拆分的问题，考虑优化
     * @param preorder
     * @param inorder
     * @return
     */
    public com.lwf.TOP100.normal.TreeNode buildTree(int[] preorder, int[] inorder) {

        if (curIndex < preorder.length && inorder != null && inorder.length > 0) {
            com.lwf.TOP100.normal.TreeNode cur = new com.lwf.TOP100.normal.TreeNode(preorder[curIndex++]);
            int index = findIndex(inorder, cur.val);
            int[] left = index < 1 ? null : Arrays.copyOfRange(inorder, 0, index);
            int[] right = index > inorder.length - 2 ? null : Arrays.copyOfRange(inorder, index + 1, inorder.length);
            cur.left = buildTree(preorder, left);
            cur.right = buildTree(preorder, right);
            return cur;
        } else {
            return null;
        }
    }

    int curIndex = 0;

    Integer findIndex(int[] ints, int element) {

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 利用左右指针代替子数组，直接在inorder的数组中标识出当前的范围，速度97，内存65
     * @param preorder
     * @param curinorder
     * @param left
     * @param right
     * @return
     */
    com.lwf.TOP100.normal.TreeNode recursive(int[] preorder, int[] curinorder, int left, int right) {
        if (curIndex < preorder.length  && left<=right) {
            com.lwf.TOP100.normal.TreeNode cur = new com.lwf.TOP100.normal.TreeNode(preorder[curIndex++]);
            int index = findIndexWithMap(curinorder, cur.val);
            cur.left = recursive(preorder,curinorder, left,index-1);
            cur.right = recursive(preorder,curinorder,index+1, right);
            return cur;
        } else {
            return null;
        }
    }
    Map<Integer,Integer> map;
    Integer findIndexWithMap(int[] ints, int element) {
    if (map==null){
        map=new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            map.put(ints[i],i);
        }
    }
        return map.get(element);
    }
}
